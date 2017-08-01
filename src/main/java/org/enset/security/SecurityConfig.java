package org.enset.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//auth.inMemoryAuthentication().withUser("admin").password("sofiane").roles("ADMIN","USER");
//auth.inMemoryAuthentication().withUser("user").password("sofiane").roles("USER");
auth.jdbcAuthentication().dataSource(datasource).
usersByUsernameQuery("select usersname as principal, password as credentials, active from users where usersname=?").
authoritiesByUsernameQuery("select usersname as principal, roles as role from users_roles where usersname=?").
rolePrefix("ROLE_").passwordEncoder(new Md5PasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin().loginPage("/login");

		http.authorizeRequests().antMatchers("/consultercompte","/operation").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
		
		
	}
}
