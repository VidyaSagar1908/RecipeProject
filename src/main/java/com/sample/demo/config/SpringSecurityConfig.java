package com.sample.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
/**
 * Contains methods to Configure authentication details in this class
 * 
 * @author Vidya sagar
 */
@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * Added the user name and password for the autherntication
	 * 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("recipe").password("password").roles("ADMIN");
	}
	
	/**
	 * // Secure the endpoins with HTTP Basic authentication
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		
	}
	
	@Bean
	public static  NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}

}
