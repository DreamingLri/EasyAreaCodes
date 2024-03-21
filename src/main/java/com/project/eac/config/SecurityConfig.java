package com.project.eac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//全局跨域请求
@Configuration
public class SecurityConfig {
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
            .authorizeHttpRequests(conf -> {
                conf.requestMatchers("hello").permitAll();
                conf.requestMatchers("")
                conf.anyRequest().authenticated();
            })
            .formLogin(conf->{
                conf.loginProcessingUrl("admin/login");
                conf.permitAll();
            })

            .cors(conf->{
                CorsConfiguration cors = new CorsConfiguration();
                cors.addAllowedOrigin("http:/localhost:8080");
                cors.setAllowCredentials(true);
                cors.addAllowedOrigin("*");
                cors.addAllowedHeader("*");
                cors.addAllowedMethod("*");
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**", cors);  //直接针对于所有地址生效
                    conf.configurationSource(source);
            })
            .build();
    }
}