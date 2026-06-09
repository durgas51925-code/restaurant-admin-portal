package com.blaze.backend.restaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blaze.backend.restaurant.jwt.JwtFilter;

@Configuration
public class SecurityConfig
{
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth ->
                     auth
                     	.requestMatchers(
                    	        "/auth/**",
                    	        "/swagger-ui/**",
                    	        "/v3/api-docs/**").permitAll()
                   
                        .requestMatchers("/employees/**").hasRole("ADMIN")

                        .requestMatchers("/menu/**").hasAnyRole("ADMIN", "MANAGER")
                  
                        .requestMatchers("/orders/**").hasAnyRole("ADMIN", "MANAGER", "STAFF")
             
                        .anyRequest().authenticated()
                )

            .addFilterBefore(
		                       jwtFilter,
		                       UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}