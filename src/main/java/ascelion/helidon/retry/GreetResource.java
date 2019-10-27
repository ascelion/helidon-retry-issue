package ascelion.helidon.retry;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
@RequestScoped
public class GreetResource {

	@Inject
	@RestClient
	private GreetRestClient client;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String message() {
		return this.client.getDefaultMessage();
	}
}
