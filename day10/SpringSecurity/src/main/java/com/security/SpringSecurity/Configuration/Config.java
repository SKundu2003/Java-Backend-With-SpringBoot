package com.security.SpringSecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.Filter;

//to create username and password
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //checking in memory with out any external database
//        auth.inMemoryAuthentication()
//                .withUser("souvik")
//                .password("test")
//                .roles("admin_role"/*,"student_role"*/) //to specify roles //can have one or more
//                .and() //to add mode user
//                .withUser("gopal")
//                .password("hello")
//                .roles("student_role");

        //Database authentication

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()//this tag will remove the HTMl page //helps to see from postman
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**") //** means after admin anything
                .hasRole("admin_role") //to acces the api should have the role of
                .antMatchers("/student/**")
                .hasAnyRole("admin_role","student_role") //any of the can access the api

                //for the API's who dont need authentication
                .antMatchers("/**").permitAll()
                .and()
                .formLogin(); //to show the login window
    }

    //PasswordEncoder Bean is mandatory
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();//to set no password encoding
    }
}