/*
 * @(#)YLstTesTrasPO.java
 */

/**
 * null
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
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.base.fornitore.FornitoreAcquisto;
import it.thera.thip.base.cliente.GiroConsegne;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YLstTesTrasPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YLstTesTras cInstance;

  /**
   * Attributo iIdListino
   */
  protected Integer iIdListino;

  /**
   * Attributo iDataInzValidita
   */
  protected java.sql.Date iDataInzValidita;

  /**
   * Attributo iDataFinValidita
   */
  protected java.sql.Date iDataFinValidita;

  /**
   * Attributo iVettore
   */
  protected Proxy iVettore = new Proxy(it.thera.thip.base.fornitore.FornitoreAcquisto.class);

  /**
   * Attributo iTipotrasporto
   */
  protected Proxy iTipotrasporto = new Proxy(it.thera.thip.base.cliente.GiroConsegne.class);

  /**
   * Attributo iYLstRigTras
   */
  protected OneToMany iYLstRigTras = new OneToMany(it.fornacecalandra.thip.base.listini.YLstRigTras.class, this, 3, false);

  
  /**
   *  retrieveList
   * @param where
   * @param orderBy
   * @param optimistic
   * @return Vector
   * @throws SQLException
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YLstTesTras)Factory.createObject(YLstTesTras.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YLstTesTras
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YLstTesTras elementWithKey(String key, int lockType) throws SQLException {
    return (YLstTesTras)PersistentObject.elementWithKey(YLstTesTras.class, key, lockType);
  }

  /**
   * YLstTesTrasPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public YLstTesTrasPO() {
    setIdListino(new Integer(0));
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param idListino
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdListino(Integer idListino) {
    this.iIdListino = idListino;
    setDirty();
    setOnDB(false);
    iYLstRigTras.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return Integer
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public Integer getIdListino() {
    return iIdListino;
  }

  /**
   * Valorizza l'attributo. 
   * @param dataInzValidita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setDataInzValidita(java.sql.Date dataInzValidita) {
    this.iDataInzValidita = dataInzValidita;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Date
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Date getDataInzValidita() {
    return iDataInzValidita;
  }

  /**
   * Valorizza l'attributo. 
   * @param dataFinValidita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setDataFinValidita(java.sql.Date dataFinValidita) {
    this.iDataFinValidita = dataFinValidita;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return java.sql.Date
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public java.sql.Date getDataFinValidita() {
    return iDataFinValidita;
  }

  /**
   * Valorizza l'attributo. 
   * @param vettore
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setVettore(FornitoreAcquisto vettore) {
    String oldObjectKey = getKey();
    String idAzienda = getIdAzienda();
    if (vettore != null) {
      idAzienda = KeyHelper.getTokenObjectKey(vettore.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iVettore.setObject(vettore);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYLstRigTras.setFatherKeyChanged();
    }
  }

  /**
   * Restituisce l'attributo. 
   * @return FornitoreAcquisto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public FornitoreAcquisto getVettore() {
    return (FornitoreAcquisto)iVettore.getObject();
  }

  /**
   * setVettoreKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setVettoreKey(String key) {
    String oldObjectKey = getKey();
    iVettore.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYLstRigTras.setFatherKeyChanged();
    }
  }

  /**
   * getVettoreKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getVettoreKey() {
    return iVettore.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idVettore
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdVettore(String idVettore) {
    String key = iVettore.getKey();
    iVettore.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idVettore));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdVettore() {
    String key = iVettore.getKey();
    String objIdVettore = KeyHelper.getTokenObjectKey(key,2);
    return objIdVettore;
  }

  /**
   * Valorizza l'attributo. 
   * @param tipotrasporto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setTipotrasporto(GiroConsegne tipotrasporto) {
    String oldObjectKey = getKey();
    String idAzienda = getIdAzienda();
    if (tipotrasporto != null) {
      idAzienda = KeyHelper.getTokenObjectKey(tipotrasporto.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iTipotrasporto.setObject(tipotrasporto);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYLstRigTras.setFatherKeyChanged();
    }
  }

  /**
   * Restituisce l'attributo. 
   * @return GiroConsegne
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public GiroConsegne getTipotrasporto() {
    return (GiroConsegne)iTipotrasporto.getObject();
  }

  /**
   * setTipotrasportoKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setTipotrasportoKey(String key) {
    String oldObjectKey = getKey();
    iTipotrasporto.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
      setOnDB(false);
      iYLstRigTras.setFatherKeyChanged();
    }
  }

  /**
   * getTipotrasportoKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getTipotrasportoKey() {
    return iTipotrasporto.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
    iYLstRigTras.setFatherKeyChanged();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param idTipoTrasporto
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdTipoTrasporto(String idTipoTrasporto) {
    String key = iTipotrasporto.getKey();
    iTipotrasporto.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idTipoTrasporto));
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdTipoTrasporto() {
    String key = iTipotrasporto.getKey();
    String objIdTipoTrasporto = KeyHelper.getTokenObjectKey(key,2);
    return objIdTipoTrasporto;
  }

  /**
   * getYLstRigTras
   * @return List
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public List getYLstRigTras() {
    return getYLstRigTrasInternal();
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YLstTesTrasPO yLstTesTrasPO = (YLstTesTrasPO)obj;
    if (yLstTesTrasPO.iDataInzValidita != null)
        iDataInzValidita = (java.sql.Date)yLstTesTrasPO.iDataInzValidita.clone();
    if (yLstTesTrasPO.iDataFinValidita != null)
        iDataFinValidita = (java.sql.Date)yLstTesTrasPO.iDataFinValidita.clone();
    iVettore.setEqual(yLstTesTrasPO.iVettore);
    iTipotrasporto.setEqual(yLstTesTrasPO.iTipotrasporto);
    iYLstRigTras.setEqual(yLstTesTrasPO.iYLstRigTras);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public Vector checkAll(BaseComponentsCollection components) {
    Vector errors = new Vector();
    if (!isOnDB()) {
      setIdListino(new Integer(0));
    }
    components.runAllChecks(errors);
    return errors;
  }

  /**
   *  setKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setIdListino(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    Integer idListino = getIdListino();
    Object[] keyParts = {idAzienda, idListino};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * saveOwnedObjects
   * @param rc
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public int saveOwnedObjects(int rc) throws SQLException {
    rc = iYLstRigTras.save(rc);
    return rc;
  }

  /**
   * deleteOwnedObjects
   * @return int
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public int deleteOwnedObjects() throws SQLException {
    return getYLstRigTrasInternal().delete();
  }

  /**
   * initializeOwnedObjects
   * @param result
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean initializeOwnedObjects(boolean result) {
    result = iYLstRigTras.initialize(result);
    return result;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  public String toString() {
    return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
  }

  /**
   *  getTableManager
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YLstTesTrasTM.getInstance();
  }

  /**
   * getYLstRigTrasInternal
   * @return OneToMany
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  protected OneToMany getYLstRigTrasInternal() {
    if (iYLstRigTras.isNew())
        iYLstRigTras.retrieve();
    return iYLstRigTras;
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 04/01/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iVettore.getKey();
    iVettore.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
    String key3 = iTipotrasporto.getKey();
    iTipotrasporto.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
  }

}

