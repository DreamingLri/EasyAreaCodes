package com.project.eac.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
                conf.requestMatchers("code/**").permitAll();
                conf.anyRequest().authenticated();
            })
            .formLogin(conf->{
                conf.loginPage("http://localhost:8081/admin/login");
                conf.loginProcessingUrl("http://localhost:8081/admin/login");
                conf.failureHandler(this::onAuthenticationFailure);
                conf.successHandler(this::onAuthenticationSuccess);
                conf.permitAll();
            })

            .cors(conf->{
                CorsConfiguration cors = new CorsConfiguration();
                cors.addAllowedOrigin("http://localhost:8081");
                cors.setAllowCredentials(true);
                cors.addExposedHeader("*");
                cors.addAllowedHeader("*");
                cors.addAllowedMethod("*");
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                    source.registerCorsConfiguration("/**", cors);  //直接针对于所有地址生效
                    conf.configurationSource(source);
            })
            .build();
    }

    private void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Authentication authentication) {
    }

    private void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         AuthenticationException e) {
    }
}