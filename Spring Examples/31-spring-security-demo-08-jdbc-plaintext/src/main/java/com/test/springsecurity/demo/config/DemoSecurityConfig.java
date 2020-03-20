package com.test.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);//Tells Spring Security to use JDBC authentication with our data source
		
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("chetan").password("test123").roles("EMPLOYEE","ADMIN"))
		.withUser(users.username("naveen").password("test123").roles("EMPLOYEE","MANAGER"))
		.withUser(users.username("samuel").password("test123").roles("EMPLOYEE","MANAGER","ADMIN"))
		.withUser(users.username("mohan").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("meghnath").password("test123").roles("EMPLOYEE","ADMIN"));*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		//.anyRequest().authenticated()
		 .antMatchers("/").hasRole("EMPLOYEE")
		 .antMatchers("/leaders/**").hasRole("MANAGER")
		 .antMatchers("/systems/**").hasRole("ADMIN")
		.and().formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout()
		.permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
