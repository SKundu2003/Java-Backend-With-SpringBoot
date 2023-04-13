package com.JWT_BootCamp.JWT.configurations;

//import com.JWT_BootCamp.JWT.Filter.JwtAuthenticationFilter;
import com.JWT_BootCamp.JWT.Services.CustomUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class jwt_config extends WebSecurityConfigurerAdapter {
//    @Autowired
//    JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    CustomUserServices userServices;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServices);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/generateToken").permitAll()//only allow this endpoint without authentication
                //for any other request authentication should be performed using "userServices"
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//every request should be indipendent to other and server does't have to manage session
                .and()
                .formLogin();

        //setting the filter
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public AuthenticationManager authenticationManager() throws Exception
    {
        return super.authenticationManager();
    }

}
