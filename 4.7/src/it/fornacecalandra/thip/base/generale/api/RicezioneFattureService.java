package it.fornacecalandra.thip.base.generale.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.gui.cnr.OpenType;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.rs.errors.ErrorUtils;
import com.thera.thermfw.rs.errors.PantheraApiException;
import com.thera.thermfw.security.Security;
import com.thera.thermfw.type.DecimalType;

import it.fornacecalandra.thip.base.vendite.generaleVE.YPsnDatiRicLaterpoint;
import it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVenRigaPrm;
import it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVendita;
import it.fornacecalandra.thip.vendite.documentoVE.ws.YOggettinoBollaNuovaLaterpoint;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClienteVendita;
import it.thera.thip.base.comuniVenAcq.TipoRigaRicerca;
import it.thera.thip.base.generale.UnitaMisura;
import it.thera.thip.base.prezziExtra.PrezziExtraTransient;
import it.thera.thip.base.ws.WebServicesLog;
import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaDataCollector;
import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaRigaPrmDataCollector;
import it.thera.thip.vendite.generaleVE.TipoDocumento;
import it.thera.thip.vendite.prezziExtra.DocRigaPrezziExtraVendita;

/**
 * <h1>Softre Solutions</h1> <br>
 * 
 * @version 1.0
 *          <h2>Servizio per ricezione fatture da Nuova Latepoint</h2>
 * 
 * @author Daniele Signoroni 07/12/2023 <br>
 *         <br>
 *         <b></b>
 *         <p>
 *         </p>
 */

public class RicezioneFattureService {

	static RicezioneFattureService service;

	public static RicezioneFattureService getRicezioneFattureService() {
		if (service == null)
			service = new RicezioneFattureService();
		return service;
	}

	protected YPsnDatiRicLaterpoint persDatiRicezione = null;

	static ErrorUtils erUtils = ErrorUtils.getInstance();

	protected List<ErrorMessage> iErrMsgList = new ArrayList<ErrorMessage>();

	public List<ErrorMessage> getErrMsgList() {
		return iErrMsgList;
	}

	public void setErrMsgList(List<ErrorMessage> iErrMsgList) {
		this.iErrMsgList = iErrMsgList;
	}

	public JSONObject riceviFatturaNuovaLaterpoint(String body, WebServicesLog log) {
		iErrMsgList.clear();
		if (body == null || body.isEmpty()) {
			throw new PantheraApiException(Status.BAD_REQUEST, erUtils.toBody(Status.BAD_REQUEST, "Body null",
					"E' stato fornito un body null o vuoto, fornire dati nel body").toString());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			YOggettinoBollaNuovaLaterpoint bolla = objectMapper.readValue(body.toString(),
					YOggettinoBollaNuovaLaterpoint.class);
			persDatiRicezione = YPsnDatiRicLaterpoint.getPersDatiRicezioneNuovaLaterpoint();
			YDocumentoVendita docVen = processaBolla(bolla);
			if (!this.getErrMsgList().isEmpty() && docVen == null) {
				getErrMsgList().add(
						new ErrorMessage("YCAL_001", "Errore importazione della fattura: " + bolla.getNumeroFattura()));
				throw new PantheraApiException(Status.INTERNAL_SERVER_ERROR,
						erUtils.toBody(Status.INTERNAL_SERVER_ERROR, this.getErrMsgList()).toString());
			} else {
				JSONObject result = new JSONObject();
				result.put("chiave_documento", docVen.getKey());
				result.put("righe_create", docVen.getRighe().size());
				if (!this.getErrMsgList().isEmpty()) {
					log.setResWarnings(erUtils.toJSON(getErrMsgList()).toString());
				}
				return result;
			}
		} catch (JsonParseException e) {
			throw new PantheraApiException(Status.INTERNAL_SERVER_ERROR,
					erUtils.toBody(Status.INTERNAL_SERVER_ERROR, "JsonParseException", e.getMessage()).toString());
		} catch (JsonMappingException e) {
			throw new PantheraApiException(Status.INTERNAL_SERVER_ERROR,
					erUtils.toBody(Status.INTERNAL_SERVER_ERROR, "JsonMappingException", e.getMessage()).toString());
		} catch (IOException e) {
			throw new PantheraApiException(Status.INTERNAL_SERVER_ERROR,
					erUtils.toBody(Status.INTERNAL_SERVER_ERROR, "IOException", e.getMessage()).toString());
		}
	}

	protected YDocumentoVendita processaBolla(YOggettinoBollaNuovaLaterpoint ogg) {
		YDocumentoVendita docVen = null;
		String cTes = KeyHelper.buildObjectKey(
				new String[] { ogg.idAzienda.trim(), ogg.idAnnoDocumento.trim(), ogg.idNumeroDocumento.trim() });
		String cRig = KeyHelper.buildObjectKey(new String[] { ogg.idAzienda.trim(), ogg.idAnnoDocumento.trim(),
				ogg.idNumeroDocumento.trim(), ogg.idRigaDocumento });
		String keyDocVen = YDocumentoVendita.getChiaveDocumentoFattuuraCalandraDaChiaveDocumentoNuovaLaterpoint(cTes,
				TipoDocumento.FATTURA, ogg.numeroFattura.substring(1));
		String keyDocVenRig = null;
		String idCauRig = null;
		try {
			if (keyDocVen != null) {
				keyDocVenRig = YDocumentoVenRigaPrm
						.getChiaveDocumentoRigaCalandraDaChiaveDocumentoRigaNuovaLaterpoint(cRig, keyDocVen);
				docVen = (YDocumentoVendita) Factory.createObject(YDocumentoVendita.class);
				docVen.setKey(keyDocVen);
				docVen.retrieve();
			} else {
				ClienteVendita cliente = YDocumentoVendita.ricercaClienteVenditaDaPartitaIvaNuovaLaterpoint(ogg.pIVA);
				if (cliente != null) {
					String idCauDoc = YPsnDatiRicLaterpoint
							.getIdCauTesDocVenDaCausaleNuovaLaterpoint(ogg.rCauDocVen.trim());
					if (idCauDoc == null) {
						getErrMsgList().add(new ErrorMessage("BAS0000000",
								"Nessun causale trascodificata con codice: " + ogg.rCauDocVen));
						return null;
					}
					idCauRig = YPsnDatiRicLaterpoint
							.getIdCauRigDocVenDaCausaleNuovaLaterpoint(ogg.rCauRigDocVen.trim());
					if (idCauRig == null) {
						getErrMsgList().add(new ErrorMessage("BAS0000000",
								"Nessun causale trascodificata con codice: " + ogg.rCauRigDocVen));
						return null;
					}
					docVen = creaDocVenTes(idCauDoc, ogg, cliente);
					docVen.setChiaveDocVenNuovaLat(cTes);
				} else {
					getErrMsgList().add(new ErrorMessage("BAS0000000", "Nessun cliente trovato con PIVA: " + ogg.pIVA));
					return null;
				}
			}
			int retSaveTes = 0;
			int retSaveRig = 0;
			int retCheckRig = BODataCollector.OK;
			int retCheckTes = 0;// checkDocVenTes(docVen);
			if (retCheckTes != BODataCollector.ERROR) {
				docVen.setFlagRiservatoUtente1(TipoDocumento.FATTURA);
				retSaveTes = docVen.save();
				docVen.retrieve();
				Articolo art = getArticoloClandraDaArticoloLatepoint(ogg.vsCodArt.trim());
				if (art == null) {
					getErrMsgList()
							.add(new ErrorMessage("BAS0000000", "Nessun articolo trovato con codice: " + ogg.vsCodArt));
					return null;
				}
				YDocumentoVenRigaPrm docVenRig = null;
				if (keyDocVenRig != null) {
					docVenRig = (YDocumentoVenRigaPrm) Factory.createObject(YDocumentoVenRigaPrm.class);
					docVenRig.setKey(keyDocVenRig);
					docVenRig.retrieve();
					creaDocVenRigaPrm(docVenRig, docVen, art, ogg, false, idCauRig);
				} else {
					docVenRig = (YDocumentoVenRigaPrm) Factory.createObject(YDocumentoVenRigaPrm.class);
					creaDocVenRigaPrm(docVenRig, docVen, art, ogg, true, idCauRig);
					docVenRig.setChiaveDocVenRigNuovaLat(cRig);
				}
				retCheckRig = checkDocVenRigaPrm(docVenRig);
				if (retCheckRig != BODataCollector.ERROR) {
					retSaveRig = docVenRig.save();
				}
				int rcTot = retCheckTes + retCheckRig + retSaveRig + retSaveTes;
				if (rcTot >= 0) {
					ConnectionManager.commit();
				} else {
					ConnectionManager.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return docVen;
	}

	public YDocumentoVendita creaDocVenTes(String idCauDoc, YOggettinoBollaNuovaLaterpoint ogg, ClienteVendita cliente)
			throws ParseException {
		Date dataBLL = getDataFMT(ogg.dataBolla);
		YDocumentoVendita docVen = (YDocumentoVendita) Factory.createObject(YDocumentoVendita.class);
		docVen.setIdAzienda(Azienda.getAziendaCorrente());
		docVen.setIdCau(idCauDoc);
		docVen.getNumeratoreHandler().setIdSerie(persDatiRicezione.getRSerieDocVen());
		docVen.getNumeratoreHandler().setDataDocumento(dataBLL);
		docVen.getNumeratoreHandler().setIdNumeratore(persDatiRicezione.getRNumeratoreDocVen());
		docVen.setCliente(cliente);
		docVen.setDataCompilazione(null);
		docVen.completaBO();
		docVen.setIdModPagamento("100");
		docVen.setAbilitaCopiaCommenti(false);
		docVen.setDataBolla(dataBLL);
		docVen.setNumeroBolla(ogg.getNumeroBolla() != null ? ogg.getNumeroBolla().trim() : null);
		docVen.setNumeroRifIntestatario(ogg.getNumeroFattura() != null ? ogg.getNumeroFattura().trim() : "");
		docVen.setDataRifIntestatario(ogg.dataFattura != null ? getDataFMT(ogg.dataFattura) : null);
		int numColliTot = 0;
		BigDecimal pesoLordoTot = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal pesoNettoTot = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		docVen.setNumeroColli(numColliTot);
		docVen.setPesoLordo(pesoLordoTot);
		docVen.setPesoNetto(pesoNettoTot);
		docVen.setRicalcolaPesiEVolume(false);
		docVen.setImportoPagVett(ogg.importoPagatoVettore);
		docVen.setDistanzaInKM(ogg.distKM != null ? Integer.valueOf(ogg.distKM) : 0);
		return docVen;
	}

	public Date getDataFMT(String data) {
		if (data == null)
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		LocalDate localDate = LocalDate.parse(data, formatter);
		Date sqlDate = Date.valueOf(localDate);
		return sqlDate;
	}

	public static Articolo getArticoloClandraDaArticoloLatepoint(String idArticolo) {
		String c = KeyHelper.buildObjectKey(new String[] { Azienda.getAziendaCorrente(), idArticolo });
		try {
			return (Articolo) Articolo.elementWithKey(Articolo.class, c, PersistentObject.NO_LOCK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void creaDocVenRigaPrm(YDocumentoVenRigaPrm docVenRig, YDocumentoVendita docVen, Articolo art,
			YOggettinoBollaNuovaLaterpoint ogg, boolean isInsert, String idCauRig) {
		try {
			if (isInsert) {
				docVenRig.setIdAzienda(Azienda.getAziendaCorrente());
				docVenRig.setTestata(docVen);
				docVenRig.completaBO();
				docVenRig.setIdCauRig(idCauRig);
			}
			docVenRig.setArticolo(art);
			Articolo articolo = docVenRig.getArticolo();
			docVenRig.cambiaArticolo(articolo, docVenRig.getConfigurazione(), false);
			UnitaMisura UMVen = articolo.getUMDefaultVendita();
			docVenRig.setUMRif(UMVen);
			docVenRig.getQtaAttesaEvasione().setQuantitaInUMRif(ogg.quantitaSpeditaUmVen);
			docVenRig.getQtaAttesaEvasione().setQuantitaInUMPrm(ogg.quantitaSpeditaUmPrm);
			docVenRig.setQtaInUMVen(ogg.quantitaSpeditaUmVen);
			docVenRig.setQtaInUMPrm(ogg.quantitaSpeditaUmPrm);
			docVenRig.setPrezzoNetto(ogg.getPrezzoNettoRiga());
			docVenRig.setPrezzo(ogg.getPrezzoNettoBase());
			docVenRig.setAbilitaCopiaCommenti(false);
			docVenRig.setDisabilitaPropAutLotti(true);
			docVenRig.setStatoAvanzamento(docVen.getStatoAvanzamento());
			if (isInsert) {
				docVenRig.istanziaRigaPrezziExtra();
				DocRigaPrezziExtraVendita rigaPrezzi = (DocRigaPrezziExtraVendita) docVenRig.getRigaPrezziExtra();
				PrezziExtraTransient p = (PrezziExtraTransient) Factory.createObject(PrezziExtraTransient.class);
				p.setPrezzoBase(ogg.prezzoNettoBase);
				p.setPrezzoXStat2(ogg.prezzoNettoTrasp);
				rigaPrezzi.setPrezziExtra(p);
				docVenRig.setRigaPrezziExtra(rigaPrezzi);
			} else {
				DocRigaPrezziExtraVendita rigaPrezzi = (DocRigaPrezziExtraVendita) docVenRig.getRigaPrezziExtra();
				rigaPrezzi.getPrezziExtra().setPrezzoBase(ogg.prezzoNettoBase);
				rigaPrezzi.getPrezziExtra().setPrezzoXStat2(ogg.prezzoNettoTrasp);
			}
			docVenRig.setProvenienzaPrezzo(TipoRigaRicerca.MANUALE);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public int checkDocVenRigaPrm(YDocumentoVenRigaPrm docVenRigPrm) throws PantheraApiException {
		int err = BODataCollector.OK;
		DocumentoVenditaRigaPrmDataCollector boDC = (DocumentoVenditaRigaPrmDataCollector) Factory
				.createObject(DocumentoVenditaRigaPrmDataCollector.class);
		boDC.initialize("DocumentoVenditaRigaPrm");
		boDC.setBo(docVenRigPrm);
		if (boDC.initSecurityServices(OpenType.NEW, true, false, true) == BODataCollector.ERROR) {
			throw new PantheraApiException(
					Status.FORBIDDEN, erUtils
							.toBody(Status.FORBIDDEN, "Non autorizzato",
									"L'utente " + Security.getCurrentUser().getId()
											+ " non e' autorizzato ad effettuare NUOVO sui DocumentiVendita")
							.toString());
		}
		boDC.loadAttValue();
		// bo.impostaSecondoCausale();
		err = boDC.check();
		if (err == BODataCollector.ERROR) {
			Vector errs = boDC.getErrorList().getErrors();
			for (int i = 0; i < errs.size(); i++) {
				ErrorMessage em = (ErrorMessage) errs.get(i);
				getErrMsgList().add(em);
			}
		}
		return err;
	}

	public static BigDecimal getBigDecimal(String s, int scale) {
		BigDecimal qta = null;
		if (s != null && !s.trim().equals("")) {
			try {
				DecimalType dt = new DecimalType();
				s = dt.unFormat(s);
				s = s.replace(DecimalType.getDecimalSeparator(), '.');
				qta = new BigDecimal(s);
				qta.setScale(scale);
			} catch (Throwable t) {
				t.printStackTrace(Trace.excStream);
			}
		}
		return qta;
	}

	@SuppressWarnings({ "rawtypes" })
	public int checkDocVenTes(YDocumentoVendita docVen) throws PantheraApiException {
		int err = BODataCollector.OK;
		DocumentoVenditaDataCollector boOC = (DocumentoVenditaDataCollector) Factory
				.createObject(DocumentoVenditaDataCollector.class);
		boOC.initialize("DocumentoVendita");
		boOC.setBo(docVen);
		if (boOC.initSecurityServices(OpenType.NEW, true, false, true) == BODataCollector.ERROR) {
			throw new PantheraApiException(
					Status.FORBIDDEN, erUtils
							.toBody(Status.FORBIDDEN, "Non autorizzato",
									"L'utente " + Security.getCurrentUser().getId()
											+ " non e' autorizzato ad effettuare NUOVO sui DocumentiVendita")
							.toString());
		}
		boOC.loadAttValue();
		boOC.impostaSecondoCausale();
		err = boOC.check();
		if (err == BODataCollector.ERROR) {
			Vector errs = boOC.getErrorList().getErrors();
			for (int i = 0; i < errs.size(); i++) {
				ErrorMessage em = (ErrorMessage) errs.get(i);
				getErrMsgList().add(em);
			}
		}
		return err;
	}
}
