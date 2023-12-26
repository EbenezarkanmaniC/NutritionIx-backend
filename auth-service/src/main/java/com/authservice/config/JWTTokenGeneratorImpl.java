package com.authservice.config;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.authservice.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenGeneratorImpl implements JWTTokenGenerator {

	@Value("${app.jwt.secret}")
	String secret;

	public Map<String, String> generateToken(User user, String SECRET_KEY, String message)
			throws UnsupportedEncodingException {

		String jwtToken = "";
		final SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY),
				SignatureAlgorithm.HS256.getJcaName());
		Map<String, Object> claims = new HashMap<>();
		claims.put("phoneNumber", user.getPhoneNumber());
		jwtToken = Jwts.builder().setClaims(claims)
				.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();
		Map<String, String> jwtTokenMap = new HashMap<>();
		jwtTokenMap.put("Token", jwtToken);
		jwtTokenMap.put("Message", message);
		return jwtTokenMap;
	}


}
