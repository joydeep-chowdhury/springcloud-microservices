package joydeep.poc.springcloud.microservices.property.accessor.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "property-file")
public class PropertyAccessServiceApplicationConfiguration {

	private String name;
	private String description;

	public PropertyAccessServiceApplicationConfiguration() {
		super();
	}

	public PropertyAccessServiceApplicationConfiguration(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public String toString() {
		return "PropertyAccessServiceApplicationConfiguration [name=" + name + ", description=" + description + "]";
	}

	

}
