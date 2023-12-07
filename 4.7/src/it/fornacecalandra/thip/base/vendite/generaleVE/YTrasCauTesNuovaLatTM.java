
package it.fornacecalandra.thip.base.vendite.generaleVE;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

import it.thera.thip.cs.DatiComuniEstesiTTM;

public class YTrasCauTesNuovaLatTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String R_CAU_NUOVA_LAT = "R_CAU_NUOVA_LAT";

	public static final String R_CAU_TES = "R_CAU_TES";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YTRAS_CAU_TES_NUOVA_LAT";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.fornacecalandra.thip.base.vendite.generaleVE.YTrasCauTesNuovaLat.class
			.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YTrasCauTesNuovaLatTM.class);
		}
		return cInstance;
	}

	public YTrasCauTesNuovaLatTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("RCauNuovaLat", R_CAU_NUOVA_LAT);
		addAttribute("IdAzienda", ID_AZIENDA);
		addAttribute("RCauTes", R_CAU_TES);

		addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
		setKeys(ID_AZIENDA + "," + R_CAU_TES);

		setTimestampColumn("TIMESTAMP_AGG");
		((it.thera.thip.cs.DatiComuniEstesiTTM) getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
	}

	private void init() throws SQLException {
		configure(R_CAU_NUOVA_LAT + ", " + ID_AZIENDA + ", " + R_CAU_TES + ", " + STATO + ", " + R_UTENTE_CRZ + ", "
				+ TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
	}

}
