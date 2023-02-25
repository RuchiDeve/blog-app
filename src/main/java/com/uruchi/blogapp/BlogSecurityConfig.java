package com.uruchi.blogapp;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@RequiredArgsConstructor
public class BlogSecurityConfig {
    //Authentication

    public  final PasswordEncoder passwordEncoder;
    @Bean
    public UserDetailsService userDetailsService() {
       UserDetails Uruchi = User.withUsername("Uruchi")
               .password(passwordEncoder.encode("12345"))
               //.roles("USER")
               .build();
         return new InMemoryUserDetailsManager(Uruchi);
    }
    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/users/").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/**")
                .authenticated().and().formLogin().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
