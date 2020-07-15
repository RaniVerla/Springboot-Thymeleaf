package org.o7plannng.sbshoppingcart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("org.o7plannng.sbshoppingcart")
@EnableWebMvc
public class ThymeleafConfig extends WebMvcConfigurerAdapter {


	  @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/app/login").setViewName("customLogin.html");
	        registry.addViewController("/app/secure/studentDetail").setViewName("student");
	    }

}
