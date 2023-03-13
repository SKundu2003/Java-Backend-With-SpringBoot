package com.securityjpa.springsecurityusingjpa.Service;

import com.securityjpa.springsecurityusingjpa.Jpa_Repo.UserReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    //this is need to authenticate using database
    //this basically fetch user from DB
    @Autowired
    UserReposetory userReposetory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userReposetory.findByUserName(username);
    }
}
