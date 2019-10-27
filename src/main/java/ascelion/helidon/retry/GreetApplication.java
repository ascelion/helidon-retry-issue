package ascelion.helidon.retry;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import static java.util.Collections.unmodifiableMap;

import org.glassfish.jersey.server.ServerProperties;

@ApplicationScoped
@ApplicationPath("/")
public class GreetApplication extends Application {
	private final Map<String, Object> properties = new HashMap<>();

	public GreetApplication() {
		this.properties.put(ServerProperties.PROVIDER_PACKAGES, getClass().getPackage().getName());
		this.properties.put(ServerProperties.PROCESSING_RESPONSE_ERRORS_ENABLED, true);
	}

	@Override
	public Map<String, Object> getProperties() {
		return unmodifiableMap(this.properties);
	}
}
