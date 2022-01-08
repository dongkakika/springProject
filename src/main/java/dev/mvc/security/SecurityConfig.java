package dev.mvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		log.info("----------Spring config check----------");
		
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER")
		.and()
			.formLogin().loginPage("/member/login")
		.and()
			.logout().logoutUrl("/member/logout").invalidateHttpSession(true)
		.and()
			.exceptionHandling().accessDeniedPage("/member/accessDenied");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
