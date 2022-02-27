package joydeep.poc.springcloud.microservices.property.accessor.exceptions;

import java.util.Map;

public class ConfigNotRefreshedException extends RuntimeException {

	private final String exceptionMessage;
	
	public ConfigNotRefreshedException(String message) {
		super(message);
		exceptionMessage = message;
	}

	public Map<String, String> exceptionBodyMap() {
		return Map.of("message", exceptionMessage);
	}

}
