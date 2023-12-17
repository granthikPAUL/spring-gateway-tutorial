package com.authService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authService.*;
import com.authService.config.JwtService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService userDetailsService;
	@GetMapping("/register")
	public String homepage() {
//		authenticationService.register();
		return "all welcome";
	}
	@PostMapping("/authenticate")
	public String homepage2(Authentication authentication,HttpServletResponse response) {
		System.out.println(authentication.isAuthenticated());
		UserDetails user=userDetailsService.loadUserByUsername(authentication.getName());
		String token=jwtService.generateToken(user);
		response.setHeader("jwt",token);
		System.out.println(response.getHeaderNames());
		System.out.println(token);
		return "put is working fine";
	}
		
}
