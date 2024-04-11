package com.example.nextgen.webmvcconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

@EnableWebMvc

public class WebMvcConfig implements WebMvcConfigurer{

		

		@Override

		public void configureViewResolvers(ViewResolverRegistry registry) {

			registry.jsp("/views/", ".jsp");
}
	}
