package com.apigateway.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.apigateway.Exception.JwtTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	@Value("${app.jwt.secret}")
	String secret;

	public Claims getClaims(final String token) throws Exception {
		try {
			final SecretKey secretKey= new SecretKeySpec(
	    			Base64.getDecoder().decode(secret),SignatureAlgorithm.HS256.getJcaName());
			Claims claim = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
			return claim;
		} catch (Exception e) {
			throw e;
		}
	}

	public Claims validateToken(final String token) throws JwtTokenException, UnsupportedEncodingException {
		try {
			System.out.println("secret "+secret);
			
			SecretKey secretKey= new SecretKeySpec(
	    			Base64.getDecoder().decode(secret),SignatureAlgorithm.HS256.getJcaName());
			System.out.println("secretkey "+secretKey);
			Claims claim = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			System.out.println("Claims "+claim);
			return claim;
		} catch (SignatureException e) {
			throw new JwtTokenException(HttpStatus.INTERNAL_SERVER_ERROR, " Invalid jwt signature \n " + e);
		} catch (MalformedJwtException e) {
			throw new JwtTokenException(HttpStatus.INTERNAL_SERVER_ERROR, " Invalid jwt Token ");
		} catch (UnsupportedJwtException e) {
			throw new JwtTokenException(HttpStatus.INTERNAL_SERVER_ERROR, " Unsupported jwt Token ");
		} catch (IllegalArgumentException e) {
			throw new JwtTokenException(HttpStatus.INTERNAL_SERVER_ERROR, " Jwt claims is empty");
		}
	}

}
