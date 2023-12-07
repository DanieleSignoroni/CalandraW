package it.softre.thip.vendite.documentoVE;

import it.thera.thip.vendite.documentoVE.DocumentoVenRigaPrm;

/**
 * 
 * @author daniele.signoroni 70687 DSSOF3 04/10/2022 Cancellazione dei
 *         riferimenti al DocumentoVendita sulla tabella SOFTRE.YUDS_VEN_RIG
 *         71308 DSSOF3 24/11/2023 merge con sorgenti std, remmato qui e
 *         spostato in
 *         {@linkplain it.fornacecalandra.thip.vendite.documentoVE.YDocumentoVenRigaPrm}
 */

public class YDocumentoVenRigaPrm extends DocumentoVenRigaPrm {

//	protected static final String UPDATE_YUDS_VEN_RIG = "UPDATE " + YUdsVenRigTM.TABLE_NAME + " SET "
//			+ YUdsVenRigTM.R_ANNO_DOC_VEN + " = null, " + YUdsVenRigTM.R_NUM_DOC_VEN + " = null, "
//			+ YUdsVenRigTM.R_RIGA_DOC_VEN + " = null, " + YUdsVenRigTM.R_RIGA_DET_DOC_VEN + " = null " + "WHERE "
//			+ YUdsVenRigTM.ID_AZIENDA + " = ? " + "AND " + YUdsVenRigTM.R_ANNO_DOC_VEN + " = ? " + "AND "
//			+ YUdsVenRigTM.R_NUM_DOC_VEN + " = ? " + "AND " + YUdsVenRigTM.R_RIGA_DOC_VEN + " = ? ";
//
//	protected static final String UPDATE_STATO_EVASIONE_YUDS_VEN_RIG = "UPDATE " + YUdsVenRigTM.TABLE_NAME + " SET "
//			+ YUdsVenRigTM.STATO_EVASIONE + " = '0' " + "WHERE " + YUdsVenRigTM.ID_UDS + " = ? " + "AND "
//			+ YUdsVenRigTM.ID_RIGA_UDS + "= ? " + "AND " + YUdsVenRigTM.ID_AZIENDA + " = ?";
//
//	public static CachedStatement cUpdateYUdsVenRig = new CachedStatement(UPDATE_YUDS_VEN_RIG);
//
//	public static CachedStatement cUpdateStatoEvasioneYUdsVenRig = new CachedStatement(
//			UPDATE_STATO_EVASIONE_YUDS_VEN_RIG);
//
//	public ErrorMessage checkDelete() {
//		ErrorMessage err = super.checkDelete();
//		if (err == null) {
//			gestioneUdsCollegate();
//		}
//		return err;
//	}
//
//	public void gestioneUdsCollegate() {
//		try {
//			String idUds = getIdUdsVendita(this.getAnnoDocumento(), this.getNumeroDocumento());
//			String idRigaUds = getIdRigaUdsVendita(this.getAnnoDocumento(), this.getNumeroDocumento(),
//					this.getNumeroRigaDocumento().toString());
//			aggiornaStatoEvasioneYUdsVenRig(idUds, idRigaUds);
//			eliminaRiferimentiDocVenYUdsVenRig();
//		} catch (Exception e) {
//			e.printStackTrace(Trace.excStream);
//		}
//	}
//
//	/**
//	 * DSSOF3 70687 Cancellazione riferimenti documento vendita riga, per la riga
//	 * uds vendita.
//	 */
//	public void aggiornaStatoEvasioneYUdsVenRig(String idUds, String riga) {
//		try {
//			if (idUds != null) {
//				PreparedStatement ps = cUpdateStatoEvasioneYUdsVenRig.getStatement();
//				Database db = ConnectionManager.getCurrentDatabase();
//				db.setString(ps, 1, idUds);
//				db.setString(ps, 2, riga);
//				db.setString(ps, 3, Azienda.getAziendaCorrente());
//				int ret = ps.executeUpdate();
//				if (ret < 0) {
//					Trace.excStream.print("Impossibile eliminare i riferimenti del documento vendita");
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace(Trace.excStream);
//		}
//	}
//
//	/**
//	 * DSSOF3 70687 In seguito alla cancellazione dei riferimenti, riporto lo stato
//	 * a 0.
//	 * 
//	 * @param idUds
//	 * @param riga
//	 */
//	public void eliminaRiferimentiDocVenYUdsVenRig() {
//		try {
//			PreparedStatement ps = cUpdateYUdsVenRig.getStatement();
//			Database db = ConnectionManager.getCurrentDatabase();
//			db.setString(ps, 1, getIdAzienda());
//			db.setString(ps, 2, getAnnoDocumento());
//			db.setString(ps, 3, getNumeroDocumento());
//			ps.setInt(4, getNumeroRigaDocumento().intValue());
//			int ret = ps.executeUpdate();
//			if (ret < 0) {
//				// Errore in fase di update
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace(Trace.excStream);
//		}
//	}
//
//	public String getIdRigaUdsVendita(String anno, String numero, String riga) {
//		String idUds = null;
//		try {
//			ResultSet rs = null;
//			String stmt = "SELECT ID_RIGA_UDS FROM SOFTRE.YUDS_VEN_RIG" + " WHERE ID_AZIENDA = '"
//					+ Azienda.getAziendaCorrente() + "'" + " AND R_ANNO_DOC_VEN = '" + anno + "'"
//					+ " AND R_NUM_DOC_VEN = '" + numero + "'" + "AND R_RIGA_DOC_VEN = '" + riga + "'";
//			CachedStatement cs = new CachedStatement(stmt);
//			rs = cs.executeQuery();
//			if (rs.next()) {
//				idUds = rs.getString("ID_RIGA_UDS") != null ? rs.getString("ID_RIGA_UDS") : "";
//			}
//			cs.free();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return idUds;
//	}
//
//	public String getIdUdsVendita(String anno, String numero) {
//		String idUds = null;
//		try {
//			ResultSet rs = null;
//			String stmt = "SELECT ID_UDS FROM SOFTRE.YUDS_VEN_TES" + " WHERE ID_AZIENDA = '"
//					+ Azienda.getAziendaCorrente() + "'" + " AND R_ANNO_DOC_VEN = '" + anno + "'"
//					+ " AND R_NUM_DOC_VEN = '" + numero + "'";
//			CachedStatement cs = new CachedStatement(stmt);
//			rs = cs.executeQuery();
//			if (rs.next()) {
//				idUds = rs.getString("ID_UDS") != null ? rs.getString("ID_UDS") : "";
//			}
//			cs.free();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return idUds;
//	}
}
