package joydeep.poc.springcloud.microservices.property.accessor.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import joydeep.poc.springcloud.microservices.property.accessor.configurations.PropertyAccessServiceApplicationConfiguration;

@RestController
@RequestMapping("/config")
public class PropertyAccessServiceController {

	private final PropertyAccessServiceApplicationConfiguration config;

	public PropertyAccessServiceController(PropertyAccessServiceApplicationConfiguration config) {
		super();
		this.config = config;
	}

	@GetMapping
	public ResponseEntity<Map<String,String>> fetchProperties() {
		Map<String,String> configObject = new HashMap<String,String>();
		configObject.put("name", config.getName());
		configObject.put("description", config.getDescription());
        return new ResponseEntity<Map<String,String>>(configObject, HttpStatus.OK);
	}

}
