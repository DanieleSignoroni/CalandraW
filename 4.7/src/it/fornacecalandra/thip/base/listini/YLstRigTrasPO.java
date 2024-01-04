package it.fornacecalandra.thip.base.listini;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import java.math.*;
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
 * 										Cambiare chiave a progressivo relativo al padre.<br>
 * 									</p>
 */

public abstract class YLstRigTrasPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Child, Conflictable {

	private static YLstRigTras cInstance;

	protected Integer iIdFascia;

	protected Short iKmDa;

	protected Short iKmA;

	protected BigDecimal iPrezzo;

	protected Proxy iParent = new Proxy(it.fornacecalandra.thip.base.listini.YLstTesTras.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YLstRigTras)Factory.createObject(YLstRigTras.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YLstRigTras elementWithKey(String key, int lockType) throws SQLException {
		return (YLstRigTras)PersistentObject.elementWithKey(YLstRigTras.class, key, lockType);
	}

	public YLstRigTrasPO() {
		setIdFascia(new Integer(0));
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setIdFascia(Integer idFascia) {
		this.iIdFascia = idFascia;
		setDirty();
		setOnDB(false);
	}

	public Integer getIdFascia() {
		return iIdFascia;
	}

	public void setKmDa(Short kmDa) {
		this.iKmDa = kmDa;
		setDirty();
	}

	public Short getKmDa() {
		return iKmDa;
	}

	public void setKmA(Short kmA) {
		this.iKmA = kmA;
		setDirty();
	}

	public Short getKmA() {
		return iKmA;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.iPrezzo = prezzo;
		setDirty();
	}
	
	public BigDecimal getPrezzo() {
		return iPrezzo;
	}

	public void setParent(YLstTesTras parent) {
		String idAzienda = getIdAzienda();
		if (parent != null) {
			idAzienda = KeyHelper.getTokenObjectKey(parent.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iParent.setObject(parent);
		setDirty();
		setOnDB(false);
	}

	public YLstTesTras getParent() {
		return (YLstTesTras)iParent.getObject();
	}

	public void setParentKey(String key) {
		iParent.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
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

	public void setIdListino(Integer idListino) {
		String key = iParent.getKey();
		iParent.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idListino));
		setDirty();
		setOnDB(false);
	}
	
	public Integer getIdListino() {
		String key = iParent.getKey();
		String objIdListino = KeyHelper.getTokenObjectKey(key,2);
		return KeyHelper.stringToIntegerObj(objIdListino);
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YLstRigTrasPO yLstRigTrasPO = (YLstRigTrasPO)obj;
		iParent.setEqual(yLstRigTrasPO.iParent);
	}

	@SuppressWarnings({ "rawtypes" })
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdListino(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 2)));
		setIdFascia(KeyHelper.stringToIntegerObj(KeyHelper.getTokenObjectKey(key, 3)));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		Integer idListino = getIdListino();
		Integer idFascia = getIdFascia();
		Object[] keyParts = {idAzienda, idListino, idFascia};
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
		return YLstRigTrasTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iParent.getKey();
		iParent.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
	}

}

