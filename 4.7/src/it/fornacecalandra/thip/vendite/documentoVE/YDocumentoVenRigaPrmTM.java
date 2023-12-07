package it.fornacecalandra.thip.vendite.documentoVE;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;

import it.thera.thip.vendite.documentoVE.DocumentoVenRigaPrmTM;

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

public class YDocumentoVenRigaPrmTM extends DocumentoVenRigaPrmTM {

	public static final String ID_DET_RIGA_DOC = "ID_DET_RIGA_DOC";

	public static final String FLAG_PERSONALIZZATO = "FLAG_PERSONALIZZATO";

	public static final String R_OGGETTO_FORNITURA = "R_OGGETTO_FORNITURA";

	public static final String SERIE = "SERIE";

	public static final String LOTTO = "LOTTO";

	public static final String PP_MQ_SOLAIO = "PP_MQ_SOLAIO";

	public static final String CARICHI_FISSI = "CARICHI_FISSI";

	public static final String CARICHI_ACC = "CARICHI_ACC";

	public static final String RES_AL_FUOCO = "RES_AL_FUOCO";

	public static final String TIPO_TRALICCIO = "TIPO_TRALICCIO";

	public static final String SUOLA_CM = "SUOLA_CM";

	public static final String H_POLISTIROLO = "H_POLISTIROLO";

	public static final String CAPPA_CM = "CAPPA_CM";

	public static final String INTERASSE_NERVATURE = "INTERASSE_NERVATURE";

	public static final String H_TRALICCI = "H_TRALICCI";

	public static final String H_BLOCCO_SOLAIO = "H_BLOCCO_SOLAIO";

	public static final String CAPPA_CM_TRAVETTI = "CAPPA_CM_TRAVETTI";

	public static final String INTERASSE_TRAVETTI = "INTERASSE_TRAVETTI";

	public static final String TRAVETTO_PREZZO = "TRAVETTO_PREZZO";

	public static final String BLOCCO = "BLOCCO";

	public static final String H_TOTALE_CM_TRAVI = "H_TOTALE_CM_TRAVI";

	public static final String RIBASSAMENTO_TRAVE = "RIBASSAMENTO_TRAVE";

	public static final String H_SUOLA_CLS_TRAVI = "H_SUOLA_CLS_TRAVI";

	public static final String RIALZO_CM_TRAVI = "RIALZO_CM_TRAVI";

	public static final String LARGHEZZA_TRAVI = "LARGHEZZA_TRAVI";

	public static final String N_TRAVI = "N_TRAVI";

	public static final String SPESSORE_INT_BILASTRE = "SPESSORE_INT_BILASTRE";

	public static final String SPESSORE_GETTO_BILASTRE = "SPESSORE_GETTO_BILASTRE";

	public static final String SPESSORE_EST_BILASTRE = "SPESSORE_EST_BILASTRE";

	public static final String ALTEZZA_INT_BILASTRE = "ALTEZZA_INT_BILASTRE";

	public static final String ALTEZZA_EST_BILASTRE = "ALTEZZA_EST_BILASTRE";

	public static final String ETICHETTA_1 = "ETICHETTA_1";

	public static final String ETICHETTA_2 = "ETICHETTA_2";

	public static final String ETICHETTA_3 = "ETICHETTA_3";

	public static final String ETICHETTA_4 = "ETICHETTA_4";

	public static final String ETICHETTA_5 = "ETICHETTA_5";

	public static final String ETICHETTA_6 = "ETICHETTA_6";

	public static final String ETICHETTA_7 = "ETICHETTA_7";

	public static final String ETICHETTA_8 = "ETICHETTA_8";

	public static final String NUMERICO_1 = "NUMERICO_1";

	public static final String NUMERICO_2 = "NUMERICO_2";

	public static final String NUMERICO_3 = "NUMERICO_3";

	public static final String NUMERICO_4 = "NUMERICO_4";

	public static final String NUMERICO_5 = "NUMERICO_5";

	public static final String NUMERICO_6 = "NUMERICO_6";

	public static final String NUMERICO_7 = "NUMERICO_7";

	public static final String NUMERICO_8 = "NUMERICO_8";

	public static final String ETICHETTA_9 = "ETICHETTA_9";

	public static final String ETICHETTA_10 = "ETICHETTA_10";

	public static final String ETICHETTA_11 = "ETICHETTA_11";

	public static final String ETICHETTA_12 = "ETICHETTA_12";

	public static final String NUMERICO_9 = "NUMERICO_9";

	public static final String NUMERICO_10 = "NUMERICO_10";

	public static final String NUMERICO_11 = "NUMERICO_11";

	public static final String ALFANUM_12 = "ALFANUM_12";

	public static final String DESC_FORN_INFO_AGG = "DESC_FORN_INFO_AGG";

	public static final String CHIAVE_DOC_VEN_RIG_NUOVA_LAT = "CHIAVE_DOC_VEN_RIG_NUOVA_LAT";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YDOCVEN_RIG_PRM";

	private static final String CLASS_NAME = it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVenRigaPrm.class
			.getName();

	public YDocumentoVenRigaPrmTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("FlagPersonalizzato", FLAG_PERSONALIZZATO, TABLE_NAME_EXT);
		addAttributeOnTable("Serie", SERIE, TABLE_NAME_EXT);
		addAttributeOnTable("Lotto", LOTTO, TABLE_NAME_EXT);
		addAttributeOnTable("PPSolaio", PP_MQ_SOLAIO, TABLE_NAME_EXT);
		addAttributeOnTable("CarichiFissi", CARICHI_FISSI, TABLE_NAME_EXT);
		addAttributeOnTable("CarichiAcc", CARICHI_ACC, TABLE_NAME_EXT);
		addAttributeOnTable("ResAlFuoco", RES_AL_FUOCO, TABLE_NAME_EXT);
		addAttributeOnTable("TipoTraliccio", TIPO_TRALICCIO, TABLE_NAME_EXT);
		addAttributeOnTable("SuolaCm", SUOLA_CM, TABLE_NAME_EXT);
		addAttributeOnTable("HPolistirolo", H_POLISTIROLO, TABLE_NAME_EXT);
		addAttributeOnTable("CappaCm", CAPPA_CM, TABLE_NAME_EXT);
		addAttributeOnTable("InterasseNervature", INTERASSE_NERVATURE, TABLE_NAME_EXT);
		addAttributeOnTable("HTralicci", H_TRALICCI, TABLE_NAME_EXT);
		addAttributeOnTable("HBloccoSolaio", H_BLOCCO_SOLAIO, TABLE_NAME_EXT);
		addAttributeOnTable("CappaCmTravetti", CAPPA_CM_TRAVETTI, TABLE_NAME_EXT);
		addAttributeOnTable("InterasseTravetti", INTERASSE_TRAVETTI, TABLE_NAME_EXT);
		addAttributeOnTable("TravettoPrezzo", TRAVETTO_PREZZO, TABLE_NAME_EXT);
		addAttributeOnTable("Blocco", BLOCCO, TABLE_NAME_EXT);
		addAttributeOnTable("HTotaleCmTravi", H_TOTALE_CM_TRAVI, TABLE_NAME_EXT);
		addAttributeOnTable("RibassamentoTrave", RIBASSAMENTO_TRAVE, TABLE_NAME_EXT);
		addAttributeOnTable("HSuolaClsTravi", H_SUOLA_CLS_TRAVI, TABLE_NAME_EXT);
		addAttributeOnTable("RialzoCmTravi", RIALZO_CM_TRAVI, TABLE_NAME_EXT);
		addAttributeOnTable("LarghezzaTravi", LARGHEZZA_TRAVI, TABLE_NAME_EXT);
		addAttributeOnTable("NTravi", N_TRAVI, TABLE_NAME_EXT);
		addAttributeOnTable("SpessoreIntBilastre", SPESSORE_INT_BILASTRE, TABLE_NAME_EXT);
		addAttributeOnTable("SpessoreGettoBilastre", SPESSORE_GETTO_BILASTRE, TABLE_NAME_EXT);
		addAttributeOnTable("SpessoreEstBilastre", SPESSORE_EST_BILASTRE, TABLE_NAME_EXT);
		addAttributeOnTable("AltezzaIntBilastre", ALTEZZA_INT_BILASTRE, TABLE_NAME_EXT);
		addAttributeOnTable("AltezzaEstBilastre", ALTEZZA_EST_BILASTRE, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta1", ETICHETTA_1, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta2", ETICHETTA_2, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta3", ETICHETTA_3, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta4", ETICHETTA_4, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta5", ETICHETTA_5, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta6", ETICHETTA_6, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta7", ETICHETTA_7, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta8", ETICHETTA_8, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico1", NUMERICO_1, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico2", NUMERICO_2, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico3", NUMERICO_3, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico4", NUMERICO_4, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico5", NUMERICO_5, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico6", NUMERICO_6, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico7", NUMERICO_7, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico8", NUMERICO_8, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta9", ETICHETTA_9, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta10", ETICHETTA_10, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta11", ETICHETTA_11, TABLE_NAME_EXT);
		addAttributeOnTable("Etichetta12", ETICHETTA_12, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico9", NUMERICO_9, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico10", NUMERICO_10, TABLE_NAME_EXT);
		addAttributeOnTable("Numerico11", NUMERICO_11, TABLE_NAME_EXT);
		addAttributeOnTable("Alfanum12", ALFANUM_12, TABLE_NAME_EXT);
		addAttributeOnTable("DescFornInfoAgg", DESC_FORN_INFO_AGG, TABLE_NAME_EXT);
		addAttributeOnTable("ROggettoFornitura", R_OGGETTO_FORNITURA, TABLE_NAME_EXT);
		addAttributeOnTable("ChiaveDocVenRigNuovaLat", CHIAVE_DOC_VEN_RIG_NUOVA_LAT, TABLE_NAME_EXT);

		getColumn(TABLE_NAME_EXT, ID_DET_RIGA_DOC).excludeFromUpdate();
		getColumn(TABLE_NAME_EXT, ID_DET_RIGA_DOC).excludeFromInsert();
	}

}
