package org.o7plannng.sbshoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("ramesh").password("ram123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("mahesh").password("mah123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/app/secure/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')").and()
				.formLogin() // login configuration
				.loginPage("/app/login")
				.loginProcessingUrl("/appLogin")
				.usernameParameter("app_username")
				.passwordParameter("app_password")
				.defaultSuccessUrl("/app/secure/studentDetail")
				.and().logout(). 																													// configuration
				logoutUrl("/appLogout").logoutSuccessUrl("/app/login");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
