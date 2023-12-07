package it.fornacecalandra.thip.vendite.documentoVE.ws;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.type.DecimalType;

import it.fornacecalandra.thip.base.vendite.generaleVE.YPsnDatiRicLaterpoint;
import it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVenRigaPrm;
import it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVendita;
import it.thera.thip.base.articolo.Articolo;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClienteVendita;
import it.thera.thip.base.comuniVenAcq.TipoRigaRicerca;
import it.thera.thip.base.generale.UnitaMisura;
import it.thera.thip.base.prezziExtra.PrezziExtraTransient;
import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaDataCollector;
import it.thera.thip.vendite.documentoVE.web.DocumentoVenditaRigaPrmDataCollector;
import it.thera.thip.vendite.generaleVE.TipoDocumento;
import it.thera.thip.vendite.prezziExtra.DocRigaPrezziExtraVendita;
import it.thera.thip.ws.GenRequestJSON;

public class YRicezioneFattureNuovaLaterpoint extends GenRequestJSON {

	protected String json;

	protected YPsnDatiRicLaterpoint persDatiRicezione = null;

	protected List<ErrorMessage> iErrMsgList = null;

	public List<ErrorMessage> getErrMsgList() {
		return iErrMsgList;
	}

	public void setErrMsgList(List<ErrorMessage> iErrMsgList) {
		this.iErrMsgList = iErrMsgList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Map execute(Map m) {
		iErrMsgList = new ArrayList();
		ArrayList jsonBolle = (ArrayList) this.getAppParams().get("jsonFatture");
		if (jsonBolle != null && !jsonBolle.isEmpty()) {
			persDatiRicezione = YPsnDatiRicLaterpoint.getPersDatiRicezioneNuovaLaterpoint();
			if (persDatiRicezione != null) {
				processaBolleNuovaLaterpoint(jsonBolle);
			} else {
				this.getErrors().add("Non e' stata definita la personalizzazione dati ricezione");
			}
		} else {
			this.getErrors().add("JSON vuoto o null");
		}
		m.put("errors", getErrMsgList());
		return m;
	}

	// considero commit singole a ogni giro
	@SuppressWarnings("rawtypes")
	protected boolean processaBolleNuovaLaterpoint(ArrayList jsonBolle) {
		for (Iterator iterator = jsonBolle.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				YOggettinoBollaNuovaLaterpoint ogg = objectMapper.readValue(object.toString(),
						YOggettinoBollaNuovaLaterpoint.class);
				processaBolla(ogg);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	protected boolean processaBolla(YOggettinoBollaNuovaLaterpoint ogg) {
		YDocumentoVendita docVen = null;
		String cTes = KeyHelper.buildObjectKey(
				new String[] { ogg.idAzienda.trim(), ogg.idAnnoDocumento.trim(), ogg.idNumeroDocumento.trim() });
		String cRig = KeyHelper.buildObjectKey(new String[] { ogg.idAzienda.trim(), ogg.idAnnoDocumento.trim(),
				ogg.idNumeroDocumento.trim(), ogg.idRigaDocumento });
		String keyDocVen = YDocumentoVendita.getChiaveDocumentoFattuuraCalandraDaChiaveDocumentoNuovaLaterpoint(cTes,
				TipoDocumento.FATTURA, ogg.numeroFattura.substring(1));
		String keyDocVenRig = null;
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
					docVen = creaDocVenTes(idCauDoc, ogg, cliente);
					docVen.setChiaveDocVenNuovaLat(cTes);
				} else {
					getErrMsgList().add(new ErrorMessage("BAS0000000", "Nessun cliente trovato con PIVA: " + ogg.pIVA));
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
					return false;
				}
				YDocumentoVenRigaPrm docVenRig = null;
				if (keyDocVenRig != null) {
					docVenRig = (YDocumentoVenRigaPrm) Factory.createObject(YDocumentoVenRigaPrm.class);
					docVenRig.setKey(keyDocVenRig);
					docVenRig.retrieve();
					creaDocVenRigaPrm(docVenRig, docVen, art, ogg, false);
				} else {
					docVenRig = (YDocumentoVenRigaPrm) Factory.createObject(YDocumentoVenRigaPrm.class);
					creaDocVenRigaPrm(docVenRig, docVen, art, ogg, true);
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
		return false;
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
		docVen.setNumeroBolla(ogg.getNumeroBolla().trim());
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
			YOggettinoBollaNuovaLaterpoint ogg, boolean isInsert) {
		try {
			if (isInsert) {
				docVenRig.setIdAzienda(Azienda.getAziendaCorrente());
				docVenRig.setTestata(docVen);
				docVenRig.completaBO();
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
	public int checkDocVenRigaPrm(YDocumentoVenRigaPrm docVenRigPrm) {
		int err = BODataCollector.OK;
		String errore = "";
		try {
			DocumentoVenditaRigaPrmDataCollector bo = (DocumentoVenditaRigaPrmDataCollector) Factory
					.createObject(DocumentoVenditaRigaPrmDataCollector.class);
			bo.initialize("DocumentoVenditaRigaPrm");
			bo.setBo(docVenRigPrm);
			bo.loadAttValue();
			// bo.impostaSecondoCausale();
			err = bo.check();
			if (err == BODataCollector.ERROR) {
				Vector errs = bo.getErrorList().getErrors();
				for (int i = 0; i < errs.size(); i++) {
					ErrorMessage em = (ErrorMessage) errs.get(i);
					getErrMsgList().add(em);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
			errore = ex.getMessage();
			getErrMsgList().add(new ErrorMessage("YCAL_001", errore));
			err = BODataCollector.ERROR;
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
	public int checkDocVenTes(YDocumentoVendita docVen) {
		int err = BODataCollector.OK;
		String errore = "";
		try {
			DocumentoVenditaDataCollector bo = (DocumentoVenditaDataCollector) Factory
					.createObject(DocumentoVenditaDataCollector.class);
			bo.initialize("DocumentoVendita");
			bo.setBo(docVen);
			bo.loadAttValue();
			bo.impostaSecondoCausale();
			err = bo.check();
			if (err == BODataCollector.ERROR) {
				Vector errs = bo.getErrorList().getErrors();
				for (int i = 0; i < errs.size(); i++) {
					ErrorMessage em = (ErrorMessage) errs.get(i);
					getErrMsgList().add(em);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace(Trace.excStream);
			errore = ex.getMessage();
			getErrMsgList().add(new ErrorMessage("YCAL_001", errore));
			err = BODataCollector.ERROR;
		}

		return err;
	}

}
