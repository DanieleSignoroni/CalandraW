package it.fornacecalandra.thip.vendite.documentoVE;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.Proxy;

import it.fornacecalandra.thip.base.YOggettoFornitura;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.vendite.documentoVE.DocumentoVenRigaPrm;

/**
 * <h1>Softre Solutions</h1> <br>
 * 
 * @author Daniele Signoroni 17/10/2023 <br>
 *         <br>
 *         <b>71264 DSSOF3 17/10/2023</b>
 *         <p>
 *         Prima stesura.
 *         </p>
 */

public class YDocumentoVenRigaPrm extends DocumentoVenRigaPrm {

	protected boolean iFlagPersonalizzato = false;

	protected String iSerie;

	protected String iLotto;

	protected Integer iPPSolaio;

	protected Integer iCarichiFissi;

	protected Integer iCarichiAcc;

	protected String iResAlFuoco;

	protected String iTipoTraliccio;

	protected Integer iSuolaCm;

	protected Integer iHPolistirolo;

	protected Integer iCappaCm;

	protected Integer iInterasseNervature;

	protected Integer iHTralicci;

	protected Integer iHBloccoSolaio;

	protected Integer iCappaCmTravetti;

	protected Integer iInterasseTravetti;

	protected BigDecimal iTravettoPrezzo;

	protected BigDecimal iBlocco;

	protected Integer iHTotaleCmTravi;

	protected Integer iRibassamentoTrave;

	protected Integer iHSuolaClsTravi;

	protected Integer iRialzoCmTravi;

	protected Integer iLarghezzaTravi;

	protected Integer iNTravi;

	protected Integer iSpessoreIntBilastre;

	protected Integer iSpessoreGettoBilastre;

	protected Integer iSpessoreEstBilastre;

	protected Integer iAltezzaIntBilastre;

	protected Integer iAltezzaEstBilastre;

	protected String iEtichetta1;

	protected String iEtichetta2;

	protected String iEtichetta3;

	protected String iEtichetta4;

	protected String iEtichetta5;

	protected String iEtichetta6;

	protected String iEtichetta7;

	protected String iEtichetta8;

	protected BigDecimal iNumerico1;

	protected BigDecimal iNumerico2;

	protected BigDecimal iNumerico3;

	protected BigDecimal iNumerico4;

	protected BigDecimal iNumerico5;

	protected BigDecimal iNumerico6;

	protected BigDecimal iNumerico7;

	protected BigDecimal iNumerico8;

	protected String iEtichetta9;

	protected String iEtichetta10;

	protected String iEtichetta11;

	protected String iEtichetta12;

	protected Integer iNumerico9;

	protected Integer iNumerico10;

	protected Integer iNumerico11;

	protected String iAlfanum12;

	protected String iDescFornInfoAgg;

	protected String iChiaveDocVenRigNuovaLat;

	protected Proxy iOggettofornitura = new Proxy(it.fornacecalandra.thip.base.YOggettoFornitura.class);

	public YDocumentoVenRigaPrm() {
		setFlagPersonalizzato(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setFlagPersonalizzato(boolean flagPersonalizzato) {
		this.iFlagPersonalizzato = flagPersonalizzato;
		setDirty();
	}

	public boolean getFlagPersonalizzato() {
		return iFlagPersonalizzato;
	}

	public void setSerie(String serie) {
		this.iSerie = serie;
		setDirty();
	}

	public String getSerie() {
		return iSerie;
	}

	public void setLotto(String lotto) {
		this.iLotto = lotto;
		setDirty();
	}

	public String getLotto() {
		return iLotto;
	}

	public void setCarichiFissi(Integer carichiFissi) {
		this.iCarichiFissi = carichiFissi;
		setDirty();
	}

	public Integer getCarichiFissi() {
		return iCarichiFissi;
	}

	public void setCarichiAcc(Integer carichiAcc) {
		this.iCarichiAcc = carichiAcc;
		setDirty();
	}

	public Integer getCarichiAcc() {
		return iCarichiAcc;
	}

	public void setResAlFuoco(String resAlFuoco) {
		this.iResAlFuoco = resAlFuoco;
		setDirty();
	}

	public String getResAlFuoco() {
		return iResAlFuoco;
	}

	public void setTipoTraliccio(String tipoTraliccio) {
		this.iTipoTraliccio = tipoTraliccio;
		setDirty();
	}

	public String getTipoTraliccio() {
		return iTipoTraliccio;
	}

	public void setSuolaCm(Integer suolaCm) {
		this.iSuolaCm = suolaCm;
		setDirty();
	}

	public Integer getSuolaCm() {
		return iSuolaCm;
	}

	public void setHPolistirolo(Integer hPolistirolo) {
		this.iHPolistirolo = hPolistirolo;
		setDirty();
	}

	public Integer getHPolistirolo() {
		return iHPolistirolo;
	}

	public void setCappaCm(Integer cappaCm) {
		this.iCappaCm = cappaCm;
		setDirty();
	}

	public Integer getCappaCm() {
		return iCappaCm;
	}

	public void setInterasseNervature(Integer interasseNervature) {
		this.iInterasseNervature = interasseNervature;
		setDirty();
	}

	public Integer getInterasseNervature() {
		return iInterasseNervature;
	}

	public void setHTralicci(Integer hTralicci) {
		this.iHTralicci = hTralicci;
		setDirty();
	}

	public Integer getHTralicci() {
		return iHTralicci;
	}

	public void setHBloccoSolaio(Integer hBloccoSolaio) {
		this.iHBloccoSolaio = hBloccoSolaio;
		setDirty();
	}

	public Integer getHBloccoSolaio() {
		return iHBloccoSolaio;
	}

	public void setCappaCmTravetti(Integer cappaCmTravetti) {
		this.iCappaCmTravetti = cappaCmTravetti;
		setDirty();
	}

	public Integer getCappaCmTravetti() {
		return iCappaCmTravetti;
	}

	public void setInterasseTravetti(Integer interasseTravetti) {
		this.iInterasseTravetti = interasseTravetti;
		setDirty();
	}

	public Integer getInterasseTravetti() {
		return iInterasseTravetti;
	}

	public void setTravettoPrezzo(BigDecimal travettoPrezzo) {
		this.iTravettoPrezzo = travettoPrezzo;
		setDirty();
	}

	public BigDecimal getTravettoPrezzo() {
		return iTravettoPrezzo;
	}

	public void setBlocco(BigDecimal blocco) {
		this.iBlocco = blocco;
		setDirty();
	}

	public BigDecimal getBlocco() {
		return iBlocco;
	}

	public void setHTotaleCmTravi(Integer hTotaleCmTravi) {
		this.iHTotaleCmTravi = hTotaleCmTravi;
		setDirty();
	}

	public Integer getHTotaleCmTravi() {
		return iHTotaleCmTravi;
	}

	public void setRibassamentoTrave(Integer ribassamentoTrave) {
		this.iRibassamentoTrave = ribassamentoTrave;
		setDirty();
	}

	public Integer getRibassamentoTrave() {
		return iRibassamentoTrave;
	}

	public void setHSuolaClsTravi(Integer hSuolaClsTravi) {
		this.iHSuolaClsTravi = hSuolaClsTravi;
		setDirty();
	}

	public Integer getHSuolaClsTravi() {
		return iHSuolaClsTravi;
	}

	public void setRialzoCmTravi(Integer rialzoCmTravi) {
		this.iRialzoCmTravi = rialzoCmTravi;
		setDirty();
	}

	public Integer getRialzoCmTravi() {
		return iRialzoCmTravi;
	}

	public void setLarghezzaTravi(Integer larghezzaTravi) {
		this.iLarghezzaTravi = larghezzaTravi;
		setDirty();
	}

	public Integer getLarghezzaTravi() {
		return iLarghezzaTravi;
	}

	public void setNTravi(Integer nTravi) {
		this.iNTravi = nTravi;
		setDirty();
	}

	public Integer getNTravi() {
		return iNTravi;
	}

	public void setSpessoreIntBilastre(Integer spessoreIntBilastre) {
		this.iSpessoreIntBilastre = spessoreIntBilastre;
		setDirty();
	}

	public Integer getSpessoreIntBilastre() {
		return iSpessoreIntBilastre;
	}

	public void setSpessoreGettoBilastre(Integer spessoreGettoBilastre) {
		this.iSpessoreGettoBilastre = spessoreGettoBilastre;
		setDirty();
	}

	public Integer getSpessoreGettoBilastre() {
		return iSpessoreGettoBilastre;
	}

	public void setSpessoreEstBilastre(Integer spessoreEstBilastre) {
		this.iSpessoreEstBilastre = spessoreEstBilastre;
		setDirty();
	}

	public Integer getSpessoreEstBilastre() {
		return iSpessoreEstBilastre;
	}

	public void setAltezzaIntBilastre(Integer altezzaIntBilastre) {
		this.iAltezzaIntBilastre = altezzaIntBilastre;
		setDirty();
	}

	public Integer getAltezzaIntBilastre() {
		return iAltezzaIntBilastre;
	}

	public void setAltezzaEstBilastre(Integer altezzaEstBilastre) {
		this.iAltezzaEstBilastre = altezzaEstBilastre;
		setDirty();
	}

	public Integer getAltezzaEstBilastre() {
		return iAltezzaEstBilastre;
	}

	public void setEtichetta1(String etichetta1) {
		this.iEtichetta1 = etichetta1;
		setDirty();
	}

	public String getEtichetta1() {
		return iEtichetta1;
	}

	public void setEtichetta2(String etichetta2) {
		this.iEtichetta2 = etichetta2;
		setDirty();
	}

	public String getEtichetta2() {
		return iEtichetta2;
	}

	public void setEtichetta3(String etichetta3) {
		this.iEtichetta3 = etichetta3;
		setDirty();
	}

	public String getEtichetta3() {
		return iEtichetta3;
	}

	public void setEtichetta4(String etichetta4) {
		this.iEtichetta4 = etichetta4;
		setDirty();
	}

	public String getEtichetta4() {
		return iEtichetta4;
	}

	public void setEtichetta5(String etichetta5) {
		this.iEtichetta5 = etichetta5;
		setDirty();
	}

	public String getEtichetta5() {
		return iEtichetta5;
	}

	public void setEtichetta6(String etichetta6) {
		this.iEtichetta6 = etichetta6;
		setDirty();
	}

	public String getEtichetta6() {
		return iEtichetta6;
	}

	public void setEtichetta7(String etichetta7) {
		this.iEtichetta7 = etichetta7;
		setDirty();
	}

	public String getEtichetta7() {
		return iEtichetta7;
	}

	public void setEtichetta8(String etichetta8) {
		this.iEtichetta8 = etichetta8;
		setDirty();
	}

	public String getEtichetta8() {
		return iEtichetta8;
	}

	public void setNumerico1(BigDecimal numerico1) {
		this.iNumerico1 = numerico1;
		setDirty();
	}

	public BigDecimal getNumerico1() {
		return iNumerico1;
	}

	public void setNumerico2(BigDecimal numerico2) {
		this.iNumerico2 = numerico2;
		setDirty();
	}

	public BigDecimal getNumerico2() {
		return iNumerico2;
	}

	public void setNumerico3(BigDecimal numerico3) {
		this.iNumerico3 = numerico3;
		setDirty();
	}

	public BigDecimal getNumerico3() {
		return iNumerico3;
	}

	public void setNumerico4(BigDecimal numerico4) {
		this.iNumerico4 = numerico4;
		setDirty();
	}

	public BigDecimal getNumerico4() {
		return iNumerico4;
	}

	public void setNumerico5(BigDecimal numerico5) {
		this.iNumerico5 = numerico5;
		setDirty();
	}

	public BigDecimal getNumerico5() {
		return iNumerico5;
	}

	public void setNumerico6(BigDecimal numerico6) {
		this.iNumerico6 = numerico6;
		setDirty();
	}

	public BigDecimal getNumerico6() {
		return iNumerico6;
	}

	public void setNumerico7(BigDecimal numerico7) {
		this.iNumerico7 = numerico7;
		setDirty();
	}

	public BigDecimal getNumerico7() {
		return iNumerico7;
	}

	public void setNumerico8(BigDecimal numerico8) {
		this.iNumerico8 = numerico8;
		setDirty();
	}

	public BigDecimal getNumerico8() {
		return iNumerico8;
	}

	public void setEtichetta9(String etichetta9) {
		this.iEtichetta9 = etichetta9;
		setDirty();
	}

	public String getEtichetta9() {
		return iEtichetta9;
	}

	public void setEtichetta10(String etichetta10) {
		this.iEtichetta10 = etichetta10;
		setDirty();
	}

	public String getEtichetta10() {
		return iEtichetta10;
	}

	public void setEtichetta11(String etichetta11) {
		this.iEtichetta11 = etichetta11;
		setDirty();
	}

	public String getEtichetta11() {
		return iEtichetta11;
	}

	public void setEtichetta12(String etichetta12) {
		this.iEtichetta12 = etichetta12;
		setDirty();
	}

	public String getEtichetta12() {
		return iEtichetta12;
	}

	public void setNumerico9(Integer numerico9) {
		this.iNumerico9 = numerico9;
		setDirty();
	}

	public Integer getNumerico9() {
		return iNumerico9;
	}

	public void setNumerico10(Integer numerico10) {
		this.iNumerico10 = numerico10;
		setDirty();
	}

	public Integer getNumerico10() {
		return iNumerico10;
	}

	public void setNumerico11(Integer numerico11) {
		this.iNumerico11 = numerico11;
		setDirty();
	}

	public Integer getNumerico11() {
		return iNumerico11;
	}

	public void setAlfanum12(String alfanum12) {
		this.iAlfanum12 = alfanum12;
		setDirty();
	}

	public String getAlfanum12() {
		return iAlfanum12;
	}

	public void setDescFornInfoAgg(String descFornInfoAgg) {
		this.iDescFornInfoAgg = descFornInfoAgg;
		setDirty();
	}

	public String getDescFornInfoAgg() {
		return iDescFornInfoAgg;
	}

	public String getChiaveDocVenRigNuovaLat() {
		return iChiaveDocVenRigNuovaLat;
	}

	public void setChiaveDocVenRigNuovaLat(String iChiaveDocVenRigNuovaLat) {
		this.iChiaveDocVenRigNuovaLat = iChiaveDocVenRigNuovaLat;
	}

	public void setOggettofornitura(YOggettoFornitura oggettofornitura) {
		String oldObjectKey = getKey();
		this.iOggettofornitura.setObject(oggettofornitura);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public YOggettoFornitura getOggettofornitura() {
		return (YOggettoFornitura) iOggettofornitura.getObject();
	}

	public void setOggettofornituraKey(String key) {
		String oldObjectKey = getKey();
		iOggettofornitura.setKey(key);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	public String getOggettofornituraKey() {
		return iOggettofornitura.getKey();
	}

	public void setROggettoFornitura(String rOggettoFornitura) {
		String key = iOggettofornitura.getKey();
		iOggettofornitura.setKey(KeyHelper.replaceTokenObjectKey(key, 1, rOggettoFornitura));
		setDirty();
	}

	public String getROggettoFornitura() {
		String key = iOggettofornitura.getKey();
		String objROggettoFornitura = KeyHelper.getTokenObjectKey(key, 1);
		return objROggettoFornitura;

	}

	public Integer getPPSolaio() {
		return iPPSolaio;
	}

	public void setPPSolaio(Integer iPPSolaio) {
		this.iPPSolaio = iPPSolaio;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YDocumentoVenRigaPrm riga = (YDocumentoVenRigaPrm) obj;
		iOggettofornitura.setEqual(riga.iOggettofornitura);// importante, altrimenti in copia non si tiene la rel
	}

	public static String getChiaveDocumentoRigaCalandraDaChiaveDocumentoRigaNuovaLaterpoint(String key,
			String keyDocVen) {
		String[] keyDocVenUNP = KeyHelper.unpackObjectKey(keyDocVen);
		String[] keyUNP = KeyHelper.unpackObjectKey(key);
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + YDocumentoVenRigaPrmTM.ID_AZIENDA + "," + YDocumentoVenRigaPrmTM.ID_ANNO_DOC + ","
				+ YDocumentoVenRigaPrmTM.ID_NUMERO_DOC + "," + YDocumentoVenRigaPrmTM.ID_RIGA_DOC + " FROM "
				+ YDocumentoVenRigaPrmTM.TABLE_NAME_EXT + " R " + " WHERE " + YDocumentoVenRigaPrmTM.ID_AZIENDA + " = '"
				+ Azienda.getAziendaCorrente() + "' AND R.ID_ANNO_DOC = '" + keyDocVenUNP[1]
				+ "' AND R.ID_NUMERO_DOC = '" + keyDocVenUNP[2] + "' "
				+ " AND SUBSTRING(CHIAVE_DOC_VEN_RIG_NUOVA_LAT, 0, 4) = '" + keyUNP[0] + "' "
				+ "	AND SUBSTRING(CHIAVE_DOC_VEN_RIG_NUOVA_LAT, 5, 4) = '" + keyUNP[1] + "' " + "	AND "
				+ "SUBSTRING(CHIAVE_DOC_VEN_RIG_NUOVA_LAT, 10, 10) = '" + keyUNP[2] + "' AND"
				+ " SUBSTRING(CHIAVE_DOC_VEN_RIG_NUOVA_LAT, 21, 1) = '" + keyUNP[3] + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				String c = KeyHelper.buildObjectKey(new String[] { rs.getString(YDocumentoVenRigaPrmTM.ID_AZIENDA),
						rs.getString(YDocumentoVenRigaPrmTM.ID_ANNO_DOC),
						rs.getString(YDocumentoVenRigaPrmTM.ID_NUMERO_DOC),
						rs.getString(YDocumentoVenRigaPrmTM.ID_RIGA_DOC) });
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
