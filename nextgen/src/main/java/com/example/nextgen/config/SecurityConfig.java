package com.example.nextgen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				
		 return http
				 .csrf().disable()
	                .authorizeHttpRequests(auth -> {
	                    auth.requestMatchers("/").permitAll();
	                    auth.requestMatchers("/favicon.ico").permitAll();
	                    auth.requestMatchers("/h2-console/**").permitAll();
	                    auth.requestMatchers("/views/**").permitAll();
	                    auth.anyRequest().authenticated();
	                                    
	                
	                })
	                .oauth2Login(withDefaults())
	                .formLogin(withDefaults())
	                .headers().frameOptions().disable().and()
	                .build();
	}
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	       
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                .username("admin")
	                .password("admin")
	                .authorities("admin")
	                .build();
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("12345")
	                .authorities("read")
	                .build();
	        return new InMemoryUserDetailsManager(admin, user);

	      
	       

	    }
}
