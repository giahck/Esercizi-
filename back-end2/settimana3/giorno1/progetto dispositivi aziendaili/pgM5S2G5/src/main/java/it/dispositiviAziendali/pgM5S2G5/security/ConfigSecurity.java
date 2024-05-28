package it.dispositiviAziendali.pgM5S2G5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class ConfigSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(e->e.disable()); // SENZA FRONT END SI BLOCCA
        httpSecurity.csrf(e->e.disable());
        httpSecurity.sessionManagement(e->e.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers(HttpMethod.GET, "/api/**").permitAll());
        //permetti a tutti di fare get su /auht/**
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers( "/api/auth/**").permitAll());
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers("/**").permitAll());
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
