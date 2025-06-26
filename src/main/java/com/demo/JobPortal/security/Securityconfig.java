package com.demo.JobPortal.security;


import com.demo.JobPortal.Services.CustomUserDetails;
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

@Configuration
@EnableWebSecurity
public class Securityconfig {

    private final UserDetailsService userDetailsService;

    public Securityconfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    SecurityFilterChain defaultsecurityFilterchain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("/auth/signup","/auth/login").permitAll()
                .requestMatchers("/employee").hasRole("EMPLOYEE")
                .requestMatchers("/employer").hasRole("EMPLOYER")
                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .logout(logout->logout.permitAll());
        return http.build();
    }
@Bean
    public PasswordEncoder passwordencoder(){

        return new BCryptPasswordEncoder();
}@Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordencoder()).and()
                .build();
    }


}
