package com.connecttalent.connecttalentsession.springsecurity;


import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }

   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
      return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtfilter, HttpSession httpSession) throws Exception {
       http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .cors(cors->cors.configurationSource(request -> {
                   CorsConfiguration config = new CorsConfiguration();
                   config.setAllowedOriginPatterns(Collections.singletonList("*"));
                   config.setAllowedMethods(Collections.singletonList("*"));
                   config.setAllowCredentials(true);
                   config.setAllowedHeaders(Collections.singletonList("*"));
                   config.setMaxAge(3600L);
                   return config;
               })).csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(auth->auth
                       .requestMatchers("/auth/**").permitAll()
                       .requestMatchers("/users/**").hasAnyAuthority("ADMIN")
                       .requestMatchers("/courses/**").hasAnyAuthority("MANAGER")
                    // .requestMatchers("/courses/**").permitAll()
               )
               .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
   }

}
