package org.krish.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityAppConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Creating Users for in-memory authentication

        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("Krish").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("Spock").password("test123").roles("EMPLOYEE","MANAGER"))
                .withUser(users.username("Kirk").password("admin123").roles("EMPLOYEE","ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*// Creating custom login form
        http.authorizeRequests() //Restrict access based on HttpServletRequest
                .anyRequest().authenticated() //Any request to the app must be authenticated(i.e logged in)
                .and()
                .formLogin()    //We're customizing the login process
                .loginPage("/login")    //Show our custom form at the request mapping.
                .loginProcessingUrl("/authenticateUser")    //login form should POST data to this URL for processing (check user id and pwd)
                .permitAll()   //Allow everyone to see this login page
                .and()
                .logout().permitAll(); //Adding logout support*/


        // Creating custom login form
        http.authorizeRequests() //Restrict access based on HttpServletRequest
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")  // /** means all sub-types
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()    //We're customizing the login process
                .loginPage("/login")    //Show our custom form at the request mapping.
                .loginProcessingUrl("/authenticateUser")    //login form should POST data to this URL for processing (check user id and pwd)
                .permitAll()   //Allow everyone to see this login page
                .and()
                .logout().permitAll(); //Adding logout support
    }
}
