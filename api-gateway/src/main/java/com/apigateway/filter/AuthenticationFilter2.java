package com.apigateway.filter;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;

import jakarta.servlet.http.HttpServletRequest;
//import jakarta.ws.rs.core.HttpHeaders;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter2 implements GatewayFilter{

	@Autowired
	private RouteValidator routeValidator;
	
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		System.out.println("entering filterChain");
		
		if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
			
			return this.onError(exchange,"Authorization Error",HttpStatus.FORBIDDEN);
		}
		String auth_header=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
		if(auth_header!=null && auth_header.startsWith("Bearer "))
		{
			auth_header=auth_header.substring(7);
			System.out.println("header "+auth_header);
		}
		try {
			
			HttpHeaders headers=new HttpHeaders();
			headers.add("Authorization","Bearer "+auth_header);
//	        headers.setAccept(Collection.singletonList\);
	        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
	        ResponseEntity<?> result =
	                restTemplate.exchange("http://127.0.0.1:8765/register", HttpMethod.GET, entity,String.class);
	        System.out.println(result.getBody());
//			ResponseEntity<String> res=restTemplate.getForEntity("http://localhost:8765/register",String.class);
//	        System.out.println(res.getBody());
			System.out.println("inside try");
			
		}catch(Exception ex)
		{
			return this.onError(exchange,"Invalid token",HttpStatus.FORBIDDEN);
		}
		/*System.out.println("entering filter");
		if (routeValidator.isSecured.test(exchange.getRequest())) {
            //header contains token or not
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
               return this.onError(exchange,"authorization missing",HttpStatus.FORBIDDEN);
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            System.out.println(authHeader);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            }
            try {
            	System.out.println("in try "+authHeader);
            	 ServerHttpRequest req = exchange.getRequest();
            	req.getHeaders().set("Authorization","Bearer "+authHeader);
//                //REST call to AUTH service
            	System.out.println("Getting headers"+req.getHeaders());
//            	 String res=restTemplate.postForObject("http://localhost:8765/register",req,String.class);

            	
            	 //                jwtUtil.validateToken(authHeader);

            } catch (Exception e) {
                System.out.println("invalid access...!");
                this.onError(exchange,"Invalid authentication",HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange);
        }
		return null;*/
		return chain.filter(exchange);
		
	}
	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)  {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

}
