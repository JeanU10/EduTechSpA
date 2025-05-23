package com.edutech.edutech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Por simplicidad, deshabilitamos CSRF (ajustar según necesidades)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Permitir todo el acceso (ajustar según necesidad)
                );
        return http.build();
    }
}
