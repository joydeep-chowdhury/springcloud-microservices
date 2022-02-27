package joydeep.poc.springcloud.microservices.property.accessor.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import joydeep.poc.springcloud.microservices.property.accessor.exceptions.ConfigNotRefreshedException;

import static joydeep.poc.springcloud.microservices.property.accessor.utils.PropertyAccessServiceUtils.CONFIG_HOST_ADDRESS;
import static joydeep.poc.springcloud.microservices.property.accessor.utils.PropertyAccessServiceUtils.CONFIG_REFRESH_ENDPOINT;
import static joydeep.poc.springcloud.microservices.property.accessor.utils.PropertyAccessServiceUtils.PROTOCOL;

@Aspect
@Service
public class PropertyAccessServiceControllerAspect {

	private static final Logger logger = LoggerFactory.getLogger(PropertyAccessServiceControllerAspect.class);
	
	@Value("${server.port}")
	private Integer PORT;
    
	@Autowired
	private RestTemplate restTemplate;
	
	@Pointcut("execution(* joydeep.poc.springcloud.microservices.property.accessor.controllers.PropertyAccessServiceController.*(..)) ")
	private void anyMethodOfPropertyAccessServiceController() {
	}

	@Before("anyMethodOfPropertyAccessServiceController()")
	public void beforeAdvice(JoinPoint joinPoint) {
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> response = restTemplate.postForEntity(URI(), httpEntity,String.class);
		if(response.getStatusCode()==HttpStatus.OK) {
			logger.info("Request successfull Http Status {} Response body {}",response.getStatusCode(), response.getBody());
		}
		else {
			String error = "Request unsuccessfull Http Status "+response.getStatusCode()+" Error Response "+response.getBody();
			logger.error(error);
			throw new ConfigNotRefreshedException(error);
		}
	}
	
	private String URI() {
		return (PROTOCOL + CONFIG_HOST_ADDRESS + ":" + PORT + CONFIG_REFRESH_ENDPOINT);
	}
}
