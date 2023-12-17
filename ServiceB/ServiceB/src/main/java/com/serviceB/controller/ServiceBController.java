package com.serviceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

	
	@GetMapping("/service-b/home")
	public String serviceB() {
		return "from service b";
	}
}
