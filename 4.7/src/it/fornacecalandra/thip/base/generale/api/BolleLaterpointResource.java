package it.fornacecalandra.thip.base.generale.api;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.thera.thermfw.base.TimeUtils;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.rs.BaseResource;
import com.thera.thermfw.rs.errors.PantheraApiException;
import com.thera.thermfw.security.Security;

import it.thera.thip.base.ws.WebServicesLog;

/**
 * <h1>Softre Solutions</h1>
 * 
 * @version 1.0
 *          <h2>Risorsa REST per ricezione dati - Nuova Laterpoint</h2>
 * @author Daniele Signoroni 07/12/2023 <br>
 *         <br>
 *         <b></b>
 *         <p>
 *         </p>
 */
@Path("/softre/nuovaLaterpoint")
public class BolleLaterpointResource extends BaseResource {

	private RicezioneBolleService serviceRicezioneBolle = RicezioneBolleService.getRicezioneBolleService();

	private RicezioneFattureService serviceRicezioneFatture = RicezioneFattureService.getRicezioneFattureService();

	@POST
	@Path("/ricezione/bolle")
	public Response ricezioneBolleLaterpoint(String body) {
		Timestamp tsCall = TimeUtils.getCurrentTimestamp();
		Status status = Status.OK;
		String res = null;
		WebServicesLog log = (WebServicesLog) Factory.createObject(WebServicesLog.class);
		log.setUtente(Security.getCurrentUser().getId());
		log.setNomeClasse(this.getClass().getName());
		JSONObject result = null;
		try {
			result = serviceRicezioneBolle.riceviBollaNuovaLaterpoint(body, log);
		} catch (PantheraApiException e) {
			status = (Status) e.getHTTPStatus();
			res = e.getMessage();
		}
		if (result == null) {
			status = Status.INTERNAL_SERVER_ERROR;
			res = "Contattare l'amministratore di sistema";
		} else {
			res = result.toString();
		}
		log.setResCode(status.getStatusCode());
		log.setResponse(res.toString());
		log.setTsChiamata(tsCall);
		log.setTsEnd(TimeUtils.getCurrentTimestamp());
		log.setReqParams(body);
		try {
			if (log.save() >= 0) {
				ConnectionManager.commit();

			} else {
				ConnectionManager.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildResponse(status, res);
	}

	@POST
	@Path("/ricezione/fatture")
	public Response ricezioneFattureLaterpoint(String body) {
		Timestamp tsCall = TimeUtils.getCurrentTimestamp();
		Status status = Status.OK;
		String res = null;
		WebServicesLog log = (WebServicesLog) Factory.createObject(WebServicesLog.class);
		log.setUtente(Security.getCurrentUser().getId());
		log.setNomeClasse(this.getClass().getName());
		JSONObject result = null;
		try {
			result = serviceRicezioneFatture.riceviFatturaNuovaLaterpoint(body, log);
		} catch (PantheraApiException e) {
			status = (Status) e.getHTTPStatus();
			res = e.getMessage();
		}
		if (result == null) {
			status = Status.INTERNAL_SERVER_ERROR;
			res = "Contattare l'amministratore di sistema";
		} else {
			res = result.toString();
		}
		log.setResCode(status.getStatusCode());
		log.setResponse(res.toString());
		log.setTsChiamata(tsCall);
		log.setTsEnd(TimeUtils.getCurrentTimestamp());
		log.setReqParams(body);
		try {
			if (log.save() >= 0) {
				ConnectionManager.commit();

			} else {
				ConnectionManager.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildResponse(status, res);
	}
}
