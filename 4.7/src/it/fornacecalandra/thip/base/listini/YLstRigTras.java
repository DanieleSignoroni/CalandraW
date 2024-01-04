package it.fornacecalandra.thip.base.listini;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Database;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.thera.thip.base.azienda.Azienda;

/**
 * 
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 15/12/2023
 * <br><br>
 * <b>71351	DSSOF3	15/12/2023</b>    <p>Prima stesura.<br>
 * 										Anagrafica listino trasporto riga.
 * 									  </p>
 * <b>71368	DSSOF3	04/01/2024</b>	<p>
 * 										Cambiare chiave a progressivo relativo al padre.<br>
 * 									</p>
 */

public class YLstRigTras extends YLstRigTrasPO {

	public static final String QUERY_SAVE = "SELECT COALESCE(MAX("+YLstRigTrasTM.ID_FASCIA+")+1,1) AS MAXI_VAL "
			+ "FROM "+YLstRigTrasTM.TABLE_NAME+" "
					+ "WHERE "+YLstRigTrasTM.ID_AZIENDA+" = ? AND "+YLstRigTrasTM.ID_LISTINO+" = ?";

	public static CachedStatement querySave = new CachedStatement(QUERY_SAVE);

	public ErrorMessage checkDelete() {
		return null;
	}

	public int save() throws SQLException {
		if (!isOnDB()) {
			ResultSet rs = null;
			int value = 1;
			Database db = ConnectionManager.getCurrentDatabase();
			synchronized(querySave){
				PreparedStatement ps = querySave.getStatement();
				db.setString(ps, 1, getIdAzienda());
				ps.setInt(2, getIdListino() == null ? 0 : getIdListino().intValue());
				rs = ps.executeQuery();
				if (rs.next())
					value = rs.getInt("MAXI_VAL");
				rs.close();
				setIdFascia(new Integer(value));
			}
		}
		return super.save();
	}
	
	/**
	 * Tramite una testata e una distanza ritorna il prezzo.
	 * @param testata
	 * @param distanza
	 * @return
	 */
	public static YLstRigTras getRigaListinoDaDistanza(YLstTesTras testata, Integer distanza) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = null;
		try {
			stmt = " SELECT "+YLstRigTrasTM.ID_AZIENDA+","+YLstTesTrasTM.ID_LISTINO+","+YLstRigTrasTM.ID_FASCIA+" "
					+ " FROM "+YLstRigTrasTM.TABLE_NAME+" L "
					+ "WHERE "+YLstRigTrasTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' "
					+ "AND "+YLstRigTrasTM.ID_LISTINO+" = '"+testata.getIdListino()+"' "
					+ "AND "+distanza+" BETWEEN "+YLstRigTrasTM.KM_DA+" AND "+YLstRigTrasTM.KM_A+" ";
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if(rs.next()) {
				return (YLstRigTras) YLstRigTras.elementWithKey(YLstRigTras.class, KeyHelper.buildObjectKey(new String[] {
						rs.getString(YLstRigTrasTM.ID_AZIENDA),
						rs.getString(YLstRigTrasTM.ID_LISTINO),
						rs.getString(YLstRigTrasTM.ID_FASCIA)
				}), PersistentObject.NO_LOCK);
			}
		}catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace(Trace.excStream);
			}
		}
		return null;
	}
}

