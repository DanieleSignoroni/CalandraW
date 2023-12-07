
package it.fornacecalandra.thip.base.vendite.generaleVE;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.ErrorCodes;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.OneToMany;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.generale.Numeratore;
import it.thera.thip.base.generale.Serie;
import it.thera.thip.cs.EntitaAzienda;

public abstract class YPsnDatiRicLaterpointPO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YPsnDatiRicLaterpoint cInstance;

	protected boolean iRicezioneAbilitata = false;

	protected Proxy iSeriedocumentovendita = new Proxy(it.thera.thip.base.generale.Serie.class);

	protected Proxy iNumeratoredocumentovendit = new Proxy(it.thera.thip.base.generale.Numeratore.class);

	protected OneToMany iYTrascodificaCauTesNL = new OneToMany(
			it.fornacecalandra.thip.base.vendite.generaleVE.YTrasCauTesNuovaLat.class, this, 1, false);

	protected OneToMany iYTrascodificaCauRigNL = new OneToMany(
			it.fornacecalandra.thip.base.vendite.generaleVE.YTrasCauRigNuovaLat.class, this, 1, false);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YPsnDatiRicLaterpoint) Factory.createObject(YPsnDatiRicLaterpoint.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YPsnDatiRicLaterpoint elementWithKey(String key, int lockType) throws SQLException {
		return (YPsnDatiRicLaterpoint) PersistentObject.elementWithKey(YPsnDatiRicLaterpoint.class, key, lockType);
	}

	public YPsnDatiRicLaterpointPO() {
		setRicezioneAbilitata(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setRicezioneAbilitata(boolean ricezioneAbilitata) {
		this.iRicezioneAbilitata = ricezioneAbilitata;
		setDirty();
	}

	public boolean getRicezioneAbilitata() {
		return iRicezioneAbilitata;
	}

	public void setSeriedocumentovendita(Serie seriedocumentovendita) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (seriedocumentovendita != null) {
			idAzienda = KeyHelper.getTokenObjectKey(seriedocumentovendita.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		String rNumeratoreDocVen = getRNumeratoreDocVen();
		if (seriedocumentovendita != null) {
			rNumeratoreDocVen = KeyHelper.getTokenObjectKey(seriedocumentovendita.getKey(), 3);
		}
		setRNumeratoreDocVenInternal(rNumeratoreDocVen);
		this.iSeriedocumentovendita.setObject(seriedocumentovendita);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYTrascodificaCauTesNL.setFatherKeyChanged();
			iYTrascodificaCauRigNL.setFatherKeyChanged();
		}
	}

	public Serie getSeriedocumentovendita() {
		return (Serie) iSeriedocumentovendita.getObject();
	}

	public void setSeriedocumentovenditaKey(String key) {
		String oldObjectKey = getKey();
		iSeriedocumentovendita.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		String rNumeratoreDocVen = KeyHelper.getTokenObjectKey(key, 3);
		setRNumeratoreDocVenInternal(rNumeratoreDocVen);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYTrascodificaCauTesNL.setFatherKeyChanged();
			iYTrascodificaCauRigNL.setFatherKeyChanged();
		}
	}

	public String getSeriedocumentovenditaKey() {
		return iSeriedocumentovendita.getKey();
	}

	public void setRSerieDocVen(String rSerieDocVen) {
		String key = iSeriedocumentovendita.getKey();
		iSeriedocumentovendita.setKey(KeyHelper.replaceTokenObjectKey(key, 2, rSerieDocVen));
		setDirty();
	}

	public String getRSerieDocVen() {
		String key = iSeriedocumentovendita.getKey();
		String objRSerieDocVen = KeyHelper.getTokenObjectKey(key, 2);
		return objRSerieDocVen;

	}

	public void setNumeratoredocumentovendit(Numeratore numeratoredocumentovendit) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (numeratoredocumentovendit != null) {
			idAzienda = KeyHelper.getTokenObjectKey(numeratoredocumentovendit.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		String rNumeratoreDocVen = getRNumeratoreDocVen();
		if (numeratoredocumentovendit != null) {
			rNumeratoreDocVen = KeyHelper.getTokenObjectKey(numeratoredocumentovendit.getKey(), 2);
		}
		setRNumeratoreDocVenInternal(rNumeratoreDocVen);
		this.iNumeratoredocumentovendit.setObject(numeratoredocumentovendit);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYTrascodificaCauTesNL.setFatherKeyChanged();
			iYTrascodificaCauRigNL.setFatherKeyChanged();
		}
	}

	public Numeratore getNumeratoredocumentovendit() {
		return (Numeratore) iNumeratoredocumentovendit.getObject();
	}

	public void setNumeratoredocumentovenditKey(String key) {
		String oldObjectKey = getKey();
		iNumeratoredocumentovendit.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		String rNumeratoreDocVen = KeyHelper.getTokenObjectKey(key, 2);
		setRNumeratoreDocVenInternal(rNumeratoreDocVen);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
			iYTrascodificaCauTesNL.setFatherKeyChanged();
			iYTrascodificaCauRigNL.setFatherKeyChanged();
		}
	}

	public String getNumeratoredocumentovenditKey() {
		return iNumeratoredocumentovendit.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
		iYTrascodificaCauTesNL.setFatherKeyChanged();
		iYTrascodificaCauRigNL.setFatherKeyChanged();
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setRNumeratoreDocVen(String rNumeratoreDocVen) {
		setRNumeratoreDocVenInternal(rNumeratoreDocVen);
		setDirty();
	}

	public String getRNumeratoreDocVen() {
		String key = iSeriedocumentovendita.getKey();
		String objRNumeratoreDocVen = KeyHelper.getTokenObjectKey(key, 3);
		return objRNumeratoreDocVen;
	}

	@SuppressWarnings("rawtypes")
	public List getYTrascodificaCauTesNL() {
		return getYTrascodificaCauTesNLInternal();
	}

	@SuppressWarnings("rawtypes")
	public List getYTrascodificaCauRigNL() {
		return getYTrascodificaCauRigNLInternal();
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YPsnDatiRicLaterpointPO yPsnDatiRicLaterpointPO = (YPsnDatiRicLaterpointPO) obj;
		iSeriedocumentovendita.setEqual(yPsnDatiRicLaterpointPO.iSeriedocumentovendita);
		iNumeratoredocumentovendit.setEqual(yPsnDatiRicLaterpointPO.iNumeratoredocumentovendit);
		iYTrascodificaCauTesNL.setEqual(yPsnDatiRicLaterpointPO.iYTrascodificaCauTesNL);
		iYTrascodificaCauRigNL.setEqual(yPsnDatiRicLaterpointPO.iYTrascodificaCauRigNL);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(key);
	}

	public String getKey() {
		return getIdAzienda();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public int saveOwnedObjects(int rc) throws SQLException {
		rc = iYTrascodificaCauTesNL.save(rc);
		rc = iYTrascodificaCauRigNL.save(rc);
		return rc;
	}

	public int deleteOwnedObjects() throws SQLException {
		int rcYTrascodificaCauTesNL = getYTrascodificaCauTesNLInternal().delete();
		if (rcYTrascodificaCauTesNL < ErrorCodes.NO_ROWS_UPDATED)
			return rcYTrascodificaCauTesNL;
		int rcYTrascodificaCauRigNL = getYTrascodificaCauRigNLInternal().delete();
		if (rcYTrascodificaCauRigNL < ErrorCodes.NO_ROWS_UPDATED)
			return rcYTrascodificaCauRigNL;
		return rcYTrascodificaCauTesNL + rcYTrascodificaCauRigNL;
	}

	public boolean initializeOwnedObjects(boolean result) {
		result = iYTrascodificaCauTesNL.initialize(result);
		result = iYTrascodificaCauRigNL.initialize(result);
		return result;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YPsnDatiRicLaterpointTM.getInstance();
	}

	protected OneToMany getYTrascodificaCauTesNLInternal() {
		if (iYTrascodificaCauTesNL.isNew())
			iYTrascodificaCauTesNL.retrieve();
		return iYTrascodificaCauTesNL;
	}

	protected OneToMany getYTrascodificaCauRigNLInternal() {
		if (iYTrascodificaCauRigNL.isNew())
			iYTrascodificaCauRigNL.retrieve();
		return iYTrascodificaCauRigNL;
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iSeriedocumentovendita.getKey();
		iSeriedocumentovendita.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iNumeratoredocumentovendit.getKey();
		iNumeratoredocumentovendit.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

	protected void setRNumeratoreDocVenInternal(String rNumeratoreDocVen) {
		String key1 = iSeriedocumentovendita.getKey();
		iSeriedocumentovendita.setKey(KeyHelper.replaceTokenObjectKey(key1, 3, rNumeratoreDocVen));
		String key2 = iNumeratoredocumentovendit.getKey();
		iNumeratoredocumentovendit.setKey(KeyHelper.replaceTokenObjectKey(key2, 2, rNumeratoreDocVen));
	}

}
