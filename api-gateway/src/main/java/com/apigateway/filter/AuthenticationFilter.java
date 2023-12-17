//package com.apigateway.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import jakarta.ws.rs.core.HttpHeaders;
//@Component
//public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
//	
//	@Autowired
//	private RouteValidator routeValidator;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	public AuthenticationFilter() {
//		super(Config.class);
//	}
//	
//	
//	public static class Config {
//		
//	}
//
//	@Override
//	public GatewayFilter apply(Config config) {
//		// TODO Auto-generated method stub
//		 return ((exchange, chain) -> {
//	            if (routeValidator.isSecured.test(exchange.getRequest())) {
//	                //header contains token or not
//	                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//	                    throw new RuntimeException("missing authorization header");
//	                }
//
//	                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//	                if (authHeader != null && authHeader.startsWith("Bearer ")) {
//	                    authHeader = authHeader.substring(7);
//	                }
//	                try {
//	                	
//	                	HttpRequest req=exchange.getRequest();
//	                	req.getHeaders().set("Authorization","Bearer "+authHeader);
////	                    //REST call to AUTH service
//	                	 restTemplate.postForObject("http://localhost:8765/authenticate",req,null);
////	                    jwtUtil.validateToken(authHeader);
//
//	                } catch (Exception e) {
//	                    System.out.println("invalid access...!");
//	                    throw new RuntimeException("un authorized access to application");
//	                }
//	            }
//	            return chain.filter(exchange);
//	        });
//	}
//
//}
