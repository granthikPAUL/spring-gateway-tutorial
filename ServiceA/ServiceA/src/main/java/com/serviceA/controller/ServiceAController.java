package com.serviceA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ServiceAController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/service-a/home")
	public String serviceA() {
		return "from service a";
	}
	
	@GetMapping("/service-a/callingb")
	public String callingB(@RequestHeader HttpHeaders headers) {
		
        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        System.out.println(entity);
        ResponseEntity<?> result =
                restTemplate.exchange("http://127.0.0.1:8765/service-b/home", HttpMethod.GET, entity,String.class);
        System.out.println(result.getBody());
		return result.getBody().toString();
	}
	
}
