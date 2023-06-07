package com.Cinema.constraints;

import com.Cinema.models.Role;
import com.Cinema.services.UsersDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    UsersDetailServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/admin/**", "/profile").hasRole(String.valueOf(Role.ADMIN))
                .requestMatchers("/films", "/sessions", "/films/**", "/sessions/**").hasAnyRole(
                        String.valueOf(Role.ADMIN),
                        String.valueOf(Role.USER)
                )
                .requestMatchers("/confirm/*", "/sign*", "/img/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().usernameParameter("email").loginPage("/signIn")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .and()
                .logout().deleteCookies("JSESSIONID").permitAll()
                .and()
                .rememberMe().key("uniqueAndSecret")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }

}

