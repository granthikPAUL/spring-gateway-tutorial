package com.apigateway.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class Jwtutil {

	
	
	private static final String SECRET_KEY="B374A26A71490437AA024E4FADD5B497FDFF1A8EA6FF12F6FB65AF2720B59CCF";
	
	
	
	public void validateToken(final String token) {
		Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
		
	}
//	public boolean isTokenValid(String token,UserDetails userDetails) {
//		final String username=extractUsername(token);
//		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//	}
	
	private Key getSignInKey() {
	
		byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	
	}
}
