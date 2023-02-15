//package com.wecare.apigateway;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
////import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////@EnableHystrix
//@Configuration
//public class GatewayConfig {
//
//    @Autowired
//    AuthenticationFilter filter;
//
//    @Autowired
//    PreFilter preFilter;
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("iam-service", r -> r.path("/api/**")
//                        .uri("lb://iam-service"))
//
//                .route("user-service", r -> r.path("/api/**")
//                        .uri("lb://user-service"))
//                .build();
//    }
//
//}
