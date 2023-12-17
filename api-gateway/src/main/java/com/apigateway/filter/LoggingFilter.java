//package com.apigateway.filter;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.web.server.ServerWebExchange;
//
//import com.apigateway.util.Jwtutil;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.ws.rs.core.HttpHeaders;
//import reactor.core.publisher.Mono;
//@Component
//public class LoggingFilter implements GlobalFilter {
//
//	
//	private Logger logger=LoggerFactory.getLogger(LoggingFilter.class);
//	
//	@Autowired
//	private Jwtutil jwtUtil;
//
////	@Override
////	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
////			throws ServletException, IOException {
////		// TODO Auto-generated method stub
////		logger.info("requested path ->{}",request.getContextPath());
////		return filterChain.doFilter(request, response);
////		
////	}
//
//	@Override
//	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 	{
//		// TODO Auto-generated method stub
//		
//		logger.info("requested path ->{}",exchange.getRequest().getPath());
//		
//		
//		return chain.filter(exchange);
//	}
//
//	
//	
//}
