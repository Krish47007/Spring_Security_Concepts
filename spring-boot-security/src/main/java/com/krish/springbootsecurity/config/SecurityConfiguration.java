package com.krish.springbootsecurity.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //This method does basic authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Creating in memory authentication
        auth.inMemoryAuthentication()
                .withUser("Krish")
                .password("Krish")
                .roles("USER")
                .and()
                .withUser("ADMIN")
                .password("ADMIN")
                .roles("ADMIN");
    }

    //This method handles the authorisation
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Come from most restrictive to least restrictive.

        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        //return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
