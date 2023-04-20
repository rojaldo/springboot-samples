package com.example.examples;


import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import com.example.examples.entities.UserEntity;
import com.example.examples.services.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

        @Autowired
        UsersService usersService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                        .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/", "/home", "/signup", "/greeting", "/login").permitAll()
                                .anyRequest().authenticated()
                        )
                        .formLogin((form) -> form
                                .permitAll()
                        )
                        .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService() {

                ArrayList<UserDetails> users = new ArrayList<UserDetails>();
                for (UserEntity user : usersService.getUsers()) {
                        users.add(User.withDefaultPasswordEncoder()
                                .username(user.getName())
                                .password(user.getEmail())
                                .roles("USER")
                                .build());
                }

                UserDetails otheruser = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("pass")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(otheruser);
        }
        
}

