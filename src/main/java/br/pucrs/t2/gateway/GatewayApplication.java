package br.pucrs.t2.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Configuration
	public class ApiGatewayConfiguration {
		@Bean
		public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
			return builder.routes()
				.route(p -> p.path("/inventory/**").uri("http://localhost:8081"))
				.route(p -> p.path("/sales/**").uri("http://localhost:8082"))
				.build();
		}
	}
}
