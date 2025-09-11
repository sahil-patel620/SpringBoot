package com.homework.Week5HomeWork.configs;

import com.homework.Week5HomeWork.filters.JwtAuthFilter;
import com.homework.Week5HomeWork.filters.LoggingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfigs {

    private final JwtAuthFilter jwtAuthFilter;
    private final LoggingFilter loggingFilter;
     @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
         httpSecurity.authorizeHttpRequests(auth-> auth
                 .requestMatchers("/posts","/auth/**","/error").permitAll()
//                                 .requestMatchers("/posts/**").authenticated()
                                 .anyRequest().authenticated())
                 .csrf(csrf-> csrf.disable())
                 .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                 .addFilterBefore(loggingFilter, JwtAuthFilter.class);

         return httpSecurity.build();
     }

     @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
         return config.getAuthenticationManager();
     }
}
