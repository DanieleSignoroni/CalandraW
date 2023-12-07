package it.fornacecalandra.thip.vendite.documentoVE;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;

import it.thera.thip.vendite.documentoVE.DocumentoVenditaTM;

public class YDocumentoVenditaTM extends DocumentoVenditaTM {

	public static final String CHIAVE_DOC_VEN_NUOVA_LAT = "CHIAVE_DOC_VEN_NUOVA_LAT";

	public static final String NUMERO_TELEFONO_DESTINAZIONE = "NUMERO_TELEFONO_DESTINAZIONE";

	public static final String TABLE_NAME_EXT = SystemParam.getSchema("THIPPERS") + "YDOC_VEN_TES";

	private static final String CLASS_NAME = it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVendita.class
			.getName();

	public YDocumentoVenditaTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		super.initialize();
		setObjClassName(CLASS_NAME);
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		linkTable(TABLE_NAME_EXT);
		addAttributeOnTable("ChiaveDocVenNuovaLat", CHIAVE_DOC_VEN_NUOVA_LAT, TABLE_NAME_EXT);
		addAttributeOnTable("NumeroTelefonoDest", NUMERO_TELEFONO_DESTINAZIONE, TABLE_NAME_EXT);

	}

}
