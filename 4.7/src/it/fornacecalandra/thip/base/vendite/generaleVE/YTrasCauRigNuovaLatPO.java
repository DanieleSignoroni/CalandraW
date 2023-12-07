
package it.fornacecalandra.thip.base.vendite.generaleVE;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.Child;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;
import it.thera.thip.vendite.generaleVE.CausaleRigaDocVen;

public abstract class YTrasCauRigNuovaLatPO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

	private static YTrasCauRigNuovaLat cInstance;

	protected String iRCauNuovaLat;

	protected Proxy iCausaledocvenrig = new Proxy(it.thera.thip.vendite.generaleVE.CausaleRigaDocVen.class);

	protected Proxy iParent = new Proxy(it.fornacecalandra.thip.base.vendite.generaleVE.YPsnDatiRicLaterpoint.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YTrasCauRigNuovaLat) Factory.createObject(YTrasCauRigNuovaLat.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YTrasCauRigNuovaLat elementWithKey(String key, int lockType) throws SQLException {
		return (YTrasCauRigNuovaLat) PersistentObject.elementWithKey(YTrasCauRigNuovaLat.class, key, lockType);
	}

	public YTrasCauRigNuovaLatPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setRCauNuovaLat(String rCauNuovaLat) {
		this.iRCauNuovaLat = rCauNuovaLat;
		setDirty();
	}

	public String getRCauNuovaLat() {
		return iRCauNuovaLat;
	}

	public void setCausaledocvenrig(CausaleRigaDocVen causaledocvenrig) {
		String idAzienda = getIdAzienda();
		if (causaledocvenrig != null) {
			idAzienda = KeyHelper.getTokenObjectKey(causaledocvenrig.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iCausaledocvenrig.setObject(causaledocvenrig);
		setDirty();
		setOnDB(false);
	}

	public CausaleRigaDocVen getCausaledocvenrig() {
		return (CausaleRigaDocVen) iCausaledocvenrig.getObject();
	}

	public void setCausaledocvenrigKey(String key) {
		iCausaledocvenrig.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getCausaledocvenrigKey() {
		return iCausaledocvenrig.getKey();
	}

	public void setRCauRig(String rCauRig) {
		String key = iCausaledocvenrig.getKey();
		iCausaledocvenrig.setKey(KeyHelper.replaceTokenObjectKey(key, 2, rCauRig));
		setDirty();
		setOnDB(false);
	}

	public String getRCauRig() {
		String key = iCausaledocvenrig.getKey();
		String objRCauRig = KeyHelper.getTokenObjectKey(key, 2);
		return objRCauRig;
	}

	public void setParent(YPsnDatiRicLaterpoint parent) {
		setIdAziendaInternal(parent.getKey());
		this.iParent.setObject(parent);
		setDirty();
		setOnDB(false);
	}

	public YPsnDatiRicLaterpoint getParent() {
		return (YPsnDatiRicLaterpoint) iParent.getObject();
	}

	public void setParentKey(String key) {
		iParent.setKey(key);
		setIdAziendaInternal(key);
		setDirty();
		setOnDB(false);
	}

	public String getParentKey() {
		return iParent.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YTrasCauRigNuovaLatPO yTrasCauRigNuovaLatPO = (YTrasCauRigNuovaLatPO) obj;
		iCausaledocvenrig.setEqual(yTrasCauRigNuovaLatPO.iCausaledocvenrig);
		iParent.setEqual(yTrasCauRigNuovaLatPO.iParent);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setRCauRig(KeyHelper.getTokenObjectKey(key, 2));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String rCauRig = getRCauRig();
		Object[] keyParts = { idAzienda, rCauRig };
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String getFatherKey() {
		return getParentKey();
	}

	public void setFatherKey(String key) {
		setParentKey(key);
	}

	public void setFather(PersistentObject father) {
		iParent.setObject(father);
	}

	public String getOrderByClause() {
		return "";
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YTrasCauRigNuovaLatTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iCausaledocvenrig.getKey();
		iCausaledocvenrig.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		iParent.setKey(idAzienda);
	}

}
