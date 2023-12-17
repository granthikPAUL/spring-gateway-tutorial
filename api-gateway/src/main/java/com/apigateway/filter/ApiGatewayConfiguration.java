package com.apigateway.filter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Autowired
	private AuthenticationFilter2 authFilter2;
	@Bean
	public RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		

		return builder.routes()
				.route(p->p.path("/service-a/**").filters(f->f.filter(authFilter2)).uri("lb://SERVICE-A"))
				.route(p->p.path("/service-b/**").filters(f->f.filter(authFilter2)).uri("lb://SERVICE-B"))
				.route(p->p.path("/**").uri("lb://AUTH-SERVICE")).build();
	
		
	}
}
