package com.example.mtbs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
{
    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        // disabling csrf protection
        http.csrf(csrf  ->csrf.disable());

        // specify public and private routes
        http.authorizeHttpRequests(auth->auth.requestMatchers(HttpMethod.POST,"/register")
                .permitAll()
                .anyRequest().authenticated());

        // type of authentication to be done
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
     PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
