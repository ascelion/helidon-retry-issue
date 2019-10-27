package ascelion.helidon.retry;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN_TYPE;

@Provider
@Dependent
public class GreetExceptionMapper implements ExceptionMapper<Exception> {
	static private final Logger LOG = Logger.getLogger(GreetExceptionMapper.class.getName());

	@Override
	public Response toResponse(Exception exception) {
		LOG.log(Level.SEVERE, "internal error", exception);

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.type(TEXT_PLAIN_TYPE)
				.entity(exception.toString())
				.build();
	}
}
