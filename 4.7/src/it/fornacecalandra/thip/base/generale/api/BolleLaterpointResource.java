package it.fornacecalandra.thip.base.generale.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.thera.thermfw.rs.BaseResource;
import com.thera.thermfw.rs.errors.PantheraApiException;

@Path("/softre/nuovaLaterpoint")
public class BolleLaterpointResource extends BaseResource {

	private RicezioneBolleService service = RicezioneBolleService.getRicezioneBolleService();

	@POST
	@Path("/ricezione/bolle")
	public Response ricezioneBolleLaterpoint(String body) {
		JSONObject result = null;
		try {
			result = service.riceviBollaNuovaLaterpoint(body);
		} catch (PantheraApiException e) {
			// il metodo tira una pantheraApiExc con status e mex
			return buildResponse(e.getHTTPStatus(), e.getMessage());
		}
		if (result == null) {
			return buildResponse(Status.INTERNAL_SERVER_ERROR, "Contattare l'amministratore di sistema");
		} else {
			return buildResponse(Status.OK, result);
		}
	}
}
