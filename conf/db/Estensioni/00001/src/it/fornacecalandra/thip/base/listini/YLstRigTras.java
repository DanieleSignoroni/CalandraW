/*
 * @(#)YLstRigTras.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera s.p.a.</b>
 * @author Wizard 04/01/2024 at 09:31:35
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 04/01/2024    Wizard     Codice generato da Wizard
 *
 */
package it.fornacecalandra.thip.base.listini;
import com.thera.thermfw.persist.*;
import java.sql.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import com.thera.thermfw.common.*;
import com.thera.thermfw.base.*;

public class YLstRigTras extends YLstRigTrasPO {

  
public static final String QUERY_SAVE = "SELECT COALESCE(MAX(ID_FASCIA)+1,1) AS MAXI_VAL FROM THIPPERS.YLST_RIG_TRAS WHERE ID_AZIENDA = ? AND ID_LISTINO = ?";

public static CachedStatement querySave = new CachedStatement(QUERY_SAVE);

  
  /**
   * checkDelete
   * @return ErrorMessage
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public ErrorMessage checkDelete() {
    /**@todo*/
    return null;
  }

  /**
   * save
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
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

}

