/*
 * @(#)YLstRigTrasTM.java
 */

/**
 * YLstRigTrasTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
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
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YLstRigTrasTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo ID_LISTINO
   */
  public static final String ID_LISTINO = "ID_LISTINO";

  /**
   * Attributo STATO
   */
  public static final String STATO = "STATO";

  /**
   * Attributo R_UTENTE_CRZ
   */
  public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

  /**
   * Attributo TIMESTAMP_CRZ
   */
  public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

  /**
   * Attributo R_UTENTE_AGG
   */
  public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

  /**
   * Attributo TIMESTAMP_AGG
   */
  public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

  /**
   * Attributo ID_FASCIA
   */
  public static final String ID_FASCIA = "ID_FASCIA";

  /**
   * Attributo KM_DA
   */
  public static final String KM_DA = "KM_DA";

  /**
   * Attributo KM_A
   */
  public static final String KM_A = "KM_A";

  /**
   * Attributo PREZZO
   */
  public static final String PREZZO = "PREZZO";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YLST_RIG_TRAS";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.fornacecalandra.thip.base.listini.YLstRigTras.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YLstRigTrasTM.class);
    }
    return cInstance;
  }

  /**
   *  YLstRigTrasTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YLstRigTrasTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    setTableName(TABLE_NAME);
    setObjClassName(CLASS_NAME);
    init();
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("IdFascia", ID_FASCIA, "getIntegerObject");
    addAttribute("KmDa", KM_DA, "getShortObject");
    addAttribute("KmA", KM_A, "getShortObject");
    addAttribute("Prezzo", PREZZO);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdListino", ID_LISTINO, "getIntegerObject");
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_LISTINO + "," + ID_FASCIA);

    setTimestampColumn("TIMESTAMP_AGG");
    ((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
  }

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID_FASCIA + ", " + KM_DA + ", " + KM_A + ", " + PREZZO
         + ", " + ID_AZIENDA + ", " + ID_LISTINO + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

