package com.apigateway.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.apigateway.filter.JwtAuthenticationFilter;
@Configuration
public class GatewayConfig {

	@Autowired
	JwtAuthenticationFilter filter;
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("NUTRITION-SERVICE", r->r.path("/nutrition/**").filters(f->f.filter(filter)).uri("http://localhost:8082"))
				.route("USER-SERVICE", r->r.path("/api/nutrition/userdetails/user/**").filters(f->f.filter(filter)).uri("http://localhost:8083"))
				.route("WISHLIST-SERVICE", r->r.path("/wishlist/**").filters(f->f.filter(filter)).uri("http://localhost:8084"))
				.build();
	}
	@Bean
	  public CorsWebFilter corsFilter() {
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.addAllowedOrigin("http://localhost:4200");
	    corsConfig.setAllowCredentials(true);
	    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
	    corsConfig.addAllowedHeader("origin");
	    corsConfig.addAllowedHeader("content-type");
	    corsConfig.addAllowedHeader("accept");
	    corsConfig.addAllowedHeader("authorization");
	    corsConfig.addAllowedHeader("cookie");
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);
	    return new CorsWebFilter(source);
	    
	  }
}
