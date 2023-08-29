package com.example.l19e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->authorize.anyRequest().permitAll());
        http.cors(c -> c.configurationSource(
                r -> {
                    CorsConfiguration con = new CorsConfiguration();
                    con.setAllowedOrigins(List.of("*")); 
                    return con;
                }
        ) );
        return http.build();
    }
}
