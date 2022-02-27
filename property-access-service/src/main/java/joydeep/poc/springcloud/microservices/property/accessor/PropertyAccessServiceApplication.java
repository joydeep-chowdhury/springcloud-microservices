package joydeep.poc.springcloud.microservices.property.accessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class PropertyAccessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyAccessServiceApplication.class, args);
	}

}
