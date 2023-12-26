package com.apigateway.filter;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.apigateway.Exception.JwtTokenException;
import com.apigateway.util.JwtUtil;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;
@Component
public class JwtAuthenticationFilter implements GatewayFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	Claims claims;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request= exchange.getRequest();
		final List<String> apiEndPoints=List.of("/auth","/api/nutrition/userdetails/saveUser");
		Predicate<ServerHttpRequest> isSecured=r->apiEndPoints.stream()
				.noneMatch(uri->r.getURI().getPath().contains(uri));
		System.out.println(isSecured);
		System.out.println(request.getHeaders().containsKey("Authorization"));
		if(isSecured.test(request)) {
			System.out.println(request.getHeaders().containsKey("Authorization"));
			if(!request.getHeaders().containsKey("Authorization")) {
				ServerHttpResponse response=exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				return response.setComplete();
			}
		final String token=request.getHeaders().getOrEmpty("Authorization").get(0);
		String tokenString=token.substring(7);	
		System.out.println(tokenString);
		try {
			claims=jwtUtil.validateToken(tokenString);
			System.out.println("Claims "+claims);
		}
		catch(JwtTokenException | UnsupportedEncodingException e) {
			ServerHttpResponse response=exchange.getResponse();
			System.out.println(response);
			response.setStatusCode(HttpStatus.BAD_REQUEST);
			return response.setComplete();
		}
			
			try {
				
				claims = jwtUtil.getClaims(tokenString);
				exchange.getRequest().mutate()
				.header("phoneNumber", String.valueOf(claims.get("phoneNumber")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(claims.get("phoneNumber"));
//			exchange.getRequest().mutate()
//			.header("phoneNumber", String.valueOf(claims.get("phoneNumber")));
		
	}
		return chain.filter(exchange);
	}

}
