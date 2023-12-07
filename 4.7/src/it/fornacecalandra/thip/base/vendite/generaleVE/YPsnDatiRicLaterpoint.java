package it.fornacecalandra.thip.base.vendite.generaleVE;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.common.ErrorMessage;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.PersistentObject;

import it.thera.thip.base.azienda.Azienda;

public class YPsnDatiRicLaterpoint extends YPsnDatiRicLaterpointPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	public static YPsnDatiRicLaterpoint getPersDatiRicezioneNuovaLaterpoint() {
		try {
			return (YPsnDatiRicLaterpoint) YPsnDatiRicLaterpoint.elementWithKey(YPsnDatiRicLaterpoint.class,
					Azienda.getAziendaCorrente(), PersistentObject.NO_LOCK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getIdCauRigDocVenDaCausaleNuovaLaterpoint(String idCauNuovaLaterpoint) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + YTrasCauRigNuovaLatTM.R_CAU_RIG + " FROM " + YTrasCauRigNuovaLatTM.TABLE_NAME + " R "
				+ " WHERE " + YTrasCauRigNuovaLatTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "' AND "
				+ YTrasCauRigNuovaLatTM.R_CAU_NUOVA_LAT + " = '" + idCauNuovaLaterpoint + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				return rs.getString(YTrasCauRigNuovaLatTM.R_CAU_RIG);
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

	public static String getIdCauTesDocVenDaCausaleNuovaLaterpoint(String idCauNuovaLaterpoint) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + YTrasCauTesNuovaLatTM.R_CAU_TES + " FROM " + YTrasCauTesNuovaLatTM.TABLE_NAME + " R "
				+ " WHERE " + YTrasCauTesNuovaLatTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "' AND "
				+ YTrasCauTesNuovaLatTM.R_CAU_NUOVA_LAT + " = '" + idCauNuovaLaterpoint + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				return rs.getString(YTrasCauTesNuovaLatTM.R_CAU_TES);
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
