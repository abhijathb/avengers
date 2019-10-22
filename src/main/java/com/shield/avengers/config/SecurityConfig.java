package com.shield.avengers.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.shield.avengers")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("USER", "ADMIN");*/
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/","/public/**", "/resources/**","/resources/static/**")
		.antMatchers("/img/**","/css/**").permitAll()
        .anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/authenticate")
		.permitAll();
		//.httpBasic();
	}
}