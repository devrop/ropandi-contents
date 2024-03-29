package ropandi.contents.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ropandi.contents.security.jwt.JwtAuthEntryPoint;
import ropandi.contents.security.jwt.JwtAuthTokenFilter;
import ropandi.contents.security.service.UserDetailsServiceImpl;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
			"/notauth",
			"/auth/**",
			"/auth/getkey/**",
			"/auth",
			"/vehicle",
			"/vehicle/**",
		//	"/menu",
		//	"/menu/**",
		//	"/role",
		//	"/role/**",
		//	"/privilege",
		//	"/privilege/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtAuthEntryPoint unauthorizedHandler;

	@Bean
	public JwtAuthTokenFilter authenticationJwtTokenFilter() {
		return new JwtAuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
}
