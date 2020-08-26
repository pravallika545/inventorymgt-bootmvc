package com.dxctraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @SpringBootapplication equivalent to 3 things
 * 1)@Configuration : so we dont have to provide on our own
 * 2)@ComponentScan: so we dont have to provide on our own
 * 3) @AutoConfiguration so we dont have to provide on our own
 */
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);

	}
	/**
	 *
	 * for handling cross origin requests
	 */
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource src=new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration=new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		src.registerCorsConfiguration("/**",configuration);
		return new CorsFilter(src);
	}
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
