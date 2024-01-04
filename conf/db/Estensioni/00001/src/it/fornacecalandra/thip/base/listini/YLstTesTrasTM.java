/*
 * @(#)YLstTesTrasTM.java
 */

/**
 * YLstTesTrasTM
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

public class YLstTesTrasTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

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
   * Attributo ID_LISTINO
   */
  public static final String ID_LISTINO = "ID_LISTINO";

  /**
   * Attributo ID_VETTORE
   */
  public static final String ID_VETTORE = "ID_VETTORE";

  /**
   * Attributo DATA_INZ_VALIDITA
   */
  public static final String DATA_INZ_VALIDITA = "DATA_INZ_VALIDITA";

  /**
   * Attributo DATA_FIN_VALIDITA
   */
  public static final String DATA_FIN_VALIDITA = "DATA_FIN_VALIDITA";

  /**
   * Attributo ID_TIPO_TRASPORTO
   */
  public static final String ID_TIPO_TRASPORTO = "ID_TIPO_TRASPORTO";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YLST_TES_TRAS";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.fornacecalandra.thip.base.listini.YLstTesTras.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(YLstTesTrasTM.class);
    }
    return cInstance;
  }

  /**
   *  YLstTesTrasTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YLstTesTrasTM() throws SQLException {
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
    addAttribute("IdListino", ID_LISTINO, "getIntegerObject");
    addAttribute("DataInzValidita", DATA_INZ_VALIDITA);
    addAttribute("DataFinValidita", DATA_FIN_VALIDITA);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdVettore", ID_VETTORE);
    addAttribute("IdTipoTrasporto", ID_TIPO_TRASPORTO);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_LISTINO);

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
    configure(ID_LISTINO + ", " + DATA_INZ_VALIDITA + ", " + DATA_FIN_VALIDITA + ", " + ID_AZIENDA
         + ", " + ID_VETTORE + ", " + ID_TIPO_TRASPORTO + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

