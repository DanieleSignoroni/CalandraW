
package it.fornacecalandra.thip.base.vendite.generaleVE;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.cs.DatiComuniEstesiTTM;

public class YPsnDatiRicLaterpointTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String RICEZIONE_ABILITATA = "RICEZIONE_ABILITATA";

	public static final String R_SERIE_DOC_VEN = "R_SERIE_DOC_VEN";

	public static final String R_NUMERATORE_DOC_VEN = "R_NUMERATORE_DOC_VEN";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YPSN_DATI_RIC_LATERPOINT";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.fornacecalandra.thip.base.vendite.generaleVE.YPsnDatiRicLaterpoint.class
			.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YPsnDatiRicLaterpointTM.class);
		}
		return cInstance;
	}

	public YPsnDatiRicLaterpointTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("RicezioneAbilitata", RICEZIONE_ABILITATA);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("RSerieDocVen", R_SERIE_DOC_VEN);
		addAttribute("RNumeratoreDocVen", R_NUMERATORE_DOC_VEN);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(RICEZIONE_ABILITATA + ", " + ID_AZIENDA + ", " + R_SERIE_DOC_VEN + ", " + R_NUMERATORE_DOC_VEN + ", "
				+ STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
