package net.mierzvoj.ProjectManagementApp.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // For REST APIs, often CSRF is disabled
                .csrf(csrf -> csrf.disable())

                // Configure authentication
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//                        // Allow public endpoints
//                        .requestMatchers("/api/auth/**", "/h2-console/**").permitAll()
//                        // Require authentication for others
//                        .anyRequest().authenticated()
//                )
//
//                // For stateless REST APIs, typically using JWT
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                );

        return http.build();
    }
}
