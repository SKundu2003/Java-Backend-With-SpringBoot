package com.securityjpa.springsecurityusingjpa.Configaration;

import com.securityjpa.springsecurityusingjpa.Service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailService myUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Database user login
        auth.userDetailsService(myUserDetailService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//this is most import with out this PostMan cant send request
                .httpBasic()//this tag will remove the HTMl page //helps to see from postman
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**") //** means after admin anything
                .hasAuthority("admin") //to acces the api should have the role of
                .antMatchers("/student/**")
                .hasAnyAuthority("admin","student") //any of the can access the api

                .antMatchers("/create**").permitAll()
                //for the API's who dont need authentication
                .antMatchers("/**").permitAll()
                .and()
                .formLogin(); //to show the login window
    }

    //PasswordEncoder Bean is mandatory
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();//to set no password encoding
    }
}
