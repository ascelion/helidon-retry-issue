package ascelion.helidon.retry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/greet")
@RegisterRestClient(baseUri = "http://localhost:9999")
interface GreetRestClient {

	@GET
	@Retry(maxRetries = 5)
	String getDefaultMessage();
}
