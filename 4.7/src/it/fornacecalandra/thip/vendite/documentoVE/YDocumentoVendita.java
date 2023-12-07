package it.fornacecalandra.thip.vendite.documentoVE;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClientePrimroseTM;
import it.thera.thip.base.cliente.ClienteVendita;
import it.thera.thip.vendite.documentoVE.DocumentoVendita;
import it.thera.thip.vendite.documentoVE.DocumentoVenditaTM;

public class YDocumentoVendita extends DocumentoVendita {

	protected String iChiaveDocVenNuovaLat;

	protected String iNumeroTelefonoDest;

	public YDocumentoVendita() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setChiaveDocVenNuovaLat(String chiaveDocVenNuovaLat) {
		this.iChiaveDocVenNuovaLat = chiaveDocVenNuovaLat;
		setDirty();
	}

	public String getChiaveDocVenNuovaLat() {
		return iChiaveDocVenNuovaLat;
	}

	public String getNumeroTelefonoDest() {
		return iNumeroTelefonoDest;
	}

	public void setNumeroTelefonoDest(String iNumeroTelefonoDestinazione) {
		this.iNumeroTelefonoDest = iNumeroTelefonoDestinazione;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

	public static String getChiaveDocumentoCalandraDaChiaveDocumentoNuovaLaterpoint(String key, char tipoDocumento) {
		String[] keyUNP = KeyHelper.unpackObjectKey(key);
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT R." + YDocumentoVenditaTM.ID_AZIENDA + ",R." + DocumentoVenditaTM.ID_ANNO_DOC + ",R."
				+ YDocumentoVenditaTM.ID_NUMERO_DOC + " FROM " + YDocumentoVenditaTM.TABLE_NAME_EXT + " R "
				+ "INNER JOIN THIP.DOC_VEN_TES T  " + "					ON R.ID_AZIENDA = T.ID_AZIENDA "
				+ "					AND R.ID_ANNO_DOC = T.ID_ANNO_DOC  "
				+ "					AND R.ID_NUMERO_DOC = T.ID_NUMERO_DOC " + " WHERE R."
				+ YDocumentoVenditaTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "' AND " + " "
				+ "	SUBSTRING(CHIAVE_DOC_VEN_NUOVA_LAT, 0, 4) = '" + keyUNP[0] + "' "
				+ "	AND SUBSTRING(CHIAVE_DOC_VEN_NUOVA_LAT, 5, 4) = '" + keyUNP[1] + "' " + "	AND "
				+ "SUBSTRING(CHIAVE_DOC_VEN_NUOVA_LAT, 10, 10) = '" + keyUNP[2] + "' AND T."
				+ DocumentoVenditaTM.FLAG_RIS_UTE_1 + " = '" + tipoDocumento + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				String c = KeyHelper.buildObjectKey(new String[] { rs.getString(YDocumentoVenditaTM.ID_AZIENDA),
						rs.getString(YDocumentoVenditaTM.ID_ANNO_DOC),
						rs.getString(YDocumentoVenditaTM.ID_NUMERO_DOC) });
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

	public static String getChiaveDocumentoFattuuraCalandraDaChiaveDocumentoNuovaLaterpoint(String key,
			char tipoDocumento, String nrFattura) {
		// String[] keyUNP = KeyHelper.unpackObjectKey(key);
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT T." + YDocumentoVenditaTM.ID_AZIENDA + ",T." + YDocumentoVenditaTM.ID_ANNO_DOC + ",T."
				+ YDocumentoVenditaTM.ID_NUMERO_DOC + " FROM " + YDocumentoVenditaTM.TABLE_NAME_EXT + " R "
				+ "INNER JOIN THIP.DOC_VEN_TES T  " + "					ON R.ID_AZIENDA = T.ID_AZIENDA "
				+ "					AND R.ID_ANNO_DOC = T.ID_ANNO_DOC  "
				+ "					AND R.ID_NUMERO_DOC = T.ID_NUMERO_DOC " + " WHERE T."
				+ YDocumentoVenditaTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "' AND " + " "
				+ DocumentoVenditaTM.FLAG_RIS_UTE_1 + " = '" + tipoDocumento + "' AND T."
				+ DocumentoVenditaTM.NUOVO_NUM_RIF_CLIENTE + " = '" + nrFattura + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				String c = KeyHelper.buildObjectKey(new String[] { rs.getString(YDocumentoVenditaTM.ID_AZIENDA),
						rs.getString(YDocumentoVenditaTM.ID_ANNO_DOC),
						rs.getString(YDocumentoVenditaTM.ID_NUMERO_DOC) });
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

	public static ClienteVendita ricercaClienteVenditaDaPartitaIvaNuovaLaterpoint(String pIVA) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + ClientePrimroseTM.ID_AZIENDA + "," + ClientePrimroseTM.ID_CLIENTE + " FROM "
				+ ClientePrimroseTM.TABLE_NAME + " R " + " WHERE " + ClientePrimroseTM.ID_AZIENDA + " = '"
				+ Azienda.getAziendaCorrente() + "' AND " + "" + " " + ClientePrimroseTM.PARTITA_IVA + " = '" + pIVA
				+ "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				String c = KeyHelper.buildObjectKey(new String[] { rs.getString(ClientePrimroseTM.ID_AZIENDA),
						rs.getString(ClientePrimroseTM.ID_CLIENTE) });
				return (ClienteVendita) ClienteVendita.elementWithKey(ClienteVendita.class, c,
						PersistentObject.NO_LOCK);
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
