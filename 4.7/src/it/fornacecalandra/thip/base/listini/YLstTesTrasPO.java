package it.fornacecalandra.thip.base.listini;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.fornitore.FornitoreAcquisto;
import it.thera.thip.base.cliente.GiroConsegne;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

/**
 * 
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 15/12/2023
 * <br><br>
 * <b>71351	DSSOF3	15/12/2023</b>    <p>Prima stesura.<br>
 * 									  </p>
 * <b>71368	DSSOF3	04/01/2024</b>	<p>
 * 										Cambiare chiave a progressivo.<br>
 * 									</p>
 */

public abstract class YLstTesTrasPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YLstTesTras cInstance;

	protected Integer iIdListino;

	protected java.sql.Date iDataInzValidita;

	protected java.sql.Date iDataFinValidita;

	protected Proxy iVettore = new Proxy(it.thera.thip.base.fornitore.FornitoreAcquisto.class);

	protected Proxy iTipotrasporto = new Proxy(it.thera.thip.base.cliente.GiroConsegne.class);

	protected OneToMany iYLstRigTras = new OneToMany(it.fornacecalandra.thip.base.listini.YLstRigTras.class, this, 3, false);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YLstTesTras)Factory.createObject(YLstTesTras.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YLstTesTras elementWithKey(String key, int lockType) throws SQLException {
		return (YLstTesTras)PersistentObject.elementWithKey(YLstTesTras.class, key, lockType);
	}

	public YLstTesTrasPO() {
		setIdListino(new Integer(0));
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdListino(Integer idListino) {
		this.iIdListino = idListino;
		setDirty();
		setOnDB(false);
		iYLstRigTras.setFatherKeyChanged();
	}

	public Integer getIdListino() {
		return iIdListino;
	}

	public void setDataInzValidita(java.sql.Date dataInzValidita) {
		this.iDataInzValidita = dataInzValidita;
		setDirty();
	}

	public java.sql.Date getDataInzValidita() {
		return iDataInzValidita;
	}

	public void setDataFinValidita(java.sql.Date dataFinValidita) {
		this.iDataFinValidita = dataFinValidita;
		setDirty();
	}

	public java.sql.Date getDataFinValidita() {
		return iDataFinValidita;
	}

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

	public FornitoreAcquisto getVettore() {
		return (FornitoreAcquisto)iVettore.getObject();
	}

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

	public String getVettoreKey() {
		return iVettore.getKey();
	}

	public void setIdVettore(String idVettore) {
		String key = iVettore.getKey();
		iVettore.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idVettore));
		setDirty();
	}

	public String getIdVettore() {
		String key = iVettore.getKey();
		String objIdVettore = KeyHelper.getTokenObjectKey(key,2);
		return objIdVettore;
	}

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

	public GiroConsegne getTipotrasporto() {
		return (GiroConsegne)iTipotrasporto.getObject();
	}

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

	public String getTipotrasportoKey() {
		return iTipotrasporto.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
		iYLstRigTras.setFatherKeyChanged();
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setIdTipoTrasporto(String idTipoTrasporto) {
		String key = iTipotrasporto.getKey();
		iTipotrasporto.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idTipoTrasporto));
		setDirty();
	}

	public String getIdTipoTrasporto() {
		String key = iTipotrasporto.getKey();
		String objIdTipoTrasporto = KeyHelper.getTokenObjectKey(key,2);
		return objIdTipoTrasporto;
	}

	public List<?> getYLstRigTras() {
		return getYLstRigTrasInternal();
	}

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

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		if (!isOnDB()) {
			setIdListino(new Integer(0));
		}
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdListino(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		Integer idListino = getIdListino();
		Object[] keyParts = {idAzienda, idListino};
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public int saveOwnedObjects(int rc) throws SQLException {
		rc = iYLstRigTras.save(rc);
		return rc;
	}

	public int deleteOwnedObjects() throws SQLException {
		return getYLstRigTrasInternal().delete();
	}

	public boolean initializeOwnedObjects(boolean result) {
		result = iYLstRigTras.initialize(result);
		return result;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YLstTesTrasTM.getInstance();
	}

	protected OneToMany getYLstRigTrasInternal() {
		if (iYLstRigTras.isNew())
			iYLstRigTras.retrieve();
		return iYLstRigTras;
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iVettore.getKey();
		iVettore.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iTipotrasporto.getKey();
		iTipotrasporto.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

}

