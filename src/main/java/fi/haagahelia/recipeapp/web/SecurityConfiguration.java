package fi.haagahelia.recipeapp.web;

//import static method antMatcher
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fi.haagahelia.recipeapp.service.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder passwordEncoder) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

	// using lambda
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(authorize -> authorize.requestMatchers(antMatcher("/css/**")).permitAll()
				.requestMatchers(antMatcher("/login")).permitAll().requestMatchers(antMatcher("/signup")).permitAll()
				.anyRequest().authenticated())
				.headers(headers -> headers.frameOptions(frameoptions -> frameoptions.disable() // for h2 console
				)).formLogin(formlogin -> formlogin.loginPage("/login").defaultSuccessUrl("/", true).permitAll())
				.logout(logout -> logout.permitAll());

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
	}
}