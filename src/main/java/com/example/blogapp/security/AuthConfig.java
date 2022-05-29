package com.example.blogapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(customUserDetailService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
		csrf().disable()
		.authorizeRequests()
	    .antMatchers("/api/user/register").permitAll()
	     .antMatchers("/v3/api-docs").permitAll()
	     .antMatchers("/v2/api-docs").permitAll()
	     .antMatchers("/swagger-resources/**").permitAll()
	     .antMatchers("/swagger-ui/**").permitAll()
	     .antMatchers("/webjars/**").permitAll()
	    .antMatchers(HttpMethod.GET).permitAll()
	    .anyRequest().authenticated()
		.and()
		.httpBasic();
	}


}
