/*
 * @(#)YLstTesTras.java
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
import it.thera.thip.base.fornitore.FornitoreAcquisto;
import it.thera.thip.base.cliente.GiroConsegne;
import com.thera.thermfw.common.*;
import com.thera.thermfw.base.*;

public class YLstTesTras extends YLstTesTrasPO {

  
  
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
      try {
        setIdListino(new Integer(Numerator.getNextInt("YLstTesTras")));
      }
      catch(NumeratorException e) {e.printStackTrace(Trace.excStream);}
    }
    return super.save();
  }

}

