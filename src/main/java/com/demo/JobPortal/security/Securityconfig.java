package com.demo.JobPortal.security;


import com.demo.JobPortal.Services.CustomUserDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class Securityconfig {

    private final UserDetailsService userDetailsService;

    public Securityconfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    SecurityFilterChain defaultsecurityFilterchain(HttpSecurity http) throws Exception{
        http
        .csrf(csrf->csrf.disable())
                .authorizeHttpRequests((auth)->
                                auth.requestMatchers("/auth/signup","/auth/signin").permitAll()
                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
               .requestMatchers("/employer/**").hasRole("EMPLOYER")
              .anyRequest().authenticated())

                .formLogin(form->form.disable())
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout.permitAll())
 .cors(cors -> cors.configurationSource(corsConfigurationSource()));

                return http.build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cfg = new CorsConfiguration();
                cfg.setAllowedOriginPatterns(Arrays.asList(
                        "http://localhost:5173"

                ));
                cfg.setAllowedMethods(Collections.singletonList("*"));
                cfg.setAllowCredentials(true);
                cfg.setAllowedHeaders(Collections.singletonList("*"));
                cfg.setExposedHeaders(Arrays.asList("Authorization"));
                cfg.setMaxAge(3600L);
                return cfg;
            }
        };
    }
@Bean
    public PasswordEncoder passwordencoder(){

        return new BCryptPasswordEncoder();
}

@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordencoder()).and()
                .build();
    }


}
