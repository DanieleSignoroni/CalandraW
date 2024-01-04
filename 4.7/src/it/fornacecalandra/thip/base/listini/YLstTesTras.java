package it.fornacecalandra.thip.base.listini;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.common.*;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.thera.thip.base.azienda.Azienda;

/**
 * 
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 15/12/2023
 * <br><br>
 * <b>71351	DSSOF3	15/12/2023</b>  <p>Prima stesura.<br>
 * 									</p>
 * <b>71368	DSSOF3	04/01/2024</b>	<p>
 * 										Cambiare chiave a progressivo.<br>
 * 										La chiave logica e' {k} = {@value YLstTesTrasTM#ID_VETTORE} + {@value YLstTesTrasTM#ID_TIPO_TRASPORTO}.<br>
 * 									 	Aggiunto quindi {@link #checkChiaveLogica()} su {@link #checkAll(BaseComponentsCollection)} .<br>
 * 									</p>
 */

public class YLstTesTras extends YLstTesTrasPO {

	public ErrorMessage checkDelete() {
		return null;
	}

	public int save() throws SQLException {
		if (!isOnDB()) {
			try {
				setIdListino(new Integer(Numerator.getNextInt("YLstTesTras")));
			}catch(NumeratorException e) {
				e.printStackTrace(Trace.excStream);
			}
			if(getDataFinValidita() == null) {
				setDataFinValidita(TimeUtils.getDate(9999, 12, 31));
			}
		}
		return super.save();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Vector<ErrorMessage> checkAll(BaseComponentsCollection components) {
		Vector<ErrorMessage> errors = super.checkAll(components);
		if(!isOnDB()) {
			ErrorMessage em = checkChiaveLogica();
			if(em != null) {
				errors.add(em);
			}
		}
		return errors;
	}

	protected ErrorMessage checkChiaveLogica() {
		if(getVettore() != null && getTipotrasporto() != null) {
			ResultSet rs = null;
			CachedStatement cs = null;
			String stmt = null;
			try {
				stmt = " SELECT 1 "
						+ " FROM "+YLstTesTrasTM.TABLE_NAME+" "
						+ "WHERE "+YLstTesTrasTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' "
						+ "AND "+YLstTesTrasTM.ID_VETTORE+" = '"+getIdVettore()+"' "
						+ "AND "+YLstTesTrasTM.ID_TIPO_TRASPORTO+" = '"+getIdTipoTrasporto()+"' ";
				cs = new CachedStatement(stmt);
				rs = cs.executeQuery();
				if(rs.next()) {
					return new ErrorMessage("BAS0000034");
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
		}
		return null;
	}

	/**
	 * Tramite vettore, giro consegna e data ritorna una testata listino trasporto valida.
	 * @param idVettore
	 * @param giroConsegna
	 * @param date
	 * @return
	 */
	public static YLstTesTras getListinoTrasportoValido(String idVettore, String giroConsegna, Date date) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = null;
		SimpleDateFormat fSQL = new SimpleDateFormat("yyyyMMdd");
		try {
			stmt = " SELECT "+YLstTesTrasTM.ID_AZIENDA+","+YLstTesTrasTM.ID_LISTINO+" "
					+ " FROM "+YLstTesTrasTM.TABLE_NAME+" L "
					+ "WHERE "+YLstTesTrasTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' "
					+ "AND "+YLstTesTrasTM.ID_VETTORE+" = '"+idVettore+"' "
					+ "AND "+YLstTesTrasTM.ID_TIPO_TRASPORTO+" = '"+giroConsegna+"' "
					+ "AND '"+fSQL.format(date)+"' BETWEEN "+YLstTesTrasTM.DATA_INZ_VALIDITA+" AND COALESCE("+YLstTesTrasTM.DATA_FIN_VALIDITA+",'99991231') ";
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if(rs.next()) {
				return (YLstTesTras) YLstTesTras.elementWithKey(YLstTesTras.class, KeyHelper.buildObjectKey(new String[] {
						rs.getString(YLstTesTrasTM.ID_AZIENDA),
						rs.getString(YLstTesTrasTM.ID_LISTINO)
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

