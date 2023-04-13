package com.JWT_BootCamp.JWT.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserServices implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//just avoiding the database connectivity

        if (username.equals("souvik"))
        {
            return new User("souvik","test", new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("there is no user named this");
        }
    }
}