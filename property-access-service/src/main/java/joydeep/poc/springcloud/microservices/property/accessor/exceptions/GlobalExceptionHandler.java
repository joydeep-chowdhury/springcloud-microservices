package joydeep.poc.springcloud.microservices.property.accessor.exceptions;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConfigNotRefreshedException.class })
	protected ResponseEntity<Map<String, String>> handleContextNotRefreshed(ConfigNotRefreshedException ex,
			WebRequest request) {
		return new ResponseEntity<Map<String, String>>(ex.exceptionBodyMap(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
