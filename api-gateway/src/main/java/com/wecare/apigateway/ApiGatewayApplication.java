package com.wecare.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
//@RestController
//@CrossOrigin(value = "http://localhost:3000" , allowedHeaders = {"Access-Control-Allow-Origin"}, methods = {RequestMethod.POST,RequestMethod.GET})
@CrossOrigin(origins = "http://localhost:3000",methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@PostMapping("/test")
//	public Map<String, Object> get(@RequestBody Map<String,Object> req){
//		return req;
//	}


	@Bean
	public WebFluxConfigurer corsMappingConfiguration(){
		return new WebFluxConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000")
						.allowedMethods("GET","POST","OPTIONS","PUT","DELETE","HEAD");
			}
		};
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/api/users").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}

}
