package com.tuna.springboot.crud_rest_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails join = User.builder()
//			.username("join")
//			.password("{noop}test123")
//			.roles("EMPLOYEE")
//			.build();
//
//		UserDetails mary = User.builder()
//			.username("mary")
//			.password("{noop}test123")
//			.roles("EMPLOYEE", "MANAGER")
//			.build();
//
//		UserDetails susan = User.builder()
//			.username("susan")
//			.password("{noop}test123")
//			.roles("EMPLOYEE", "MANAGER", "ADMIN")
//			.build();
//
//		return new InMemoryUserDetailsManager(join, mary, susan);
//	}
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		jdbcUserDetailsManager.setUsersByUsernameQuery(
			"select email, password, active from employee where email=?"
		);
		
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
			"select employee_id, role from roles where employee_id=?"
		);
		
		return jdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer ->
			configurer
				.requestMatchers(HttpMethod.GET, "api/employees").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
		);
		
		// use HTTP basic authentication
		http.httpBasic();
		
		// disable cross site request forgery (CSRF)
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE and PATCH
		http.csrf().disable();
		
		return http.build();
	}
	
}
