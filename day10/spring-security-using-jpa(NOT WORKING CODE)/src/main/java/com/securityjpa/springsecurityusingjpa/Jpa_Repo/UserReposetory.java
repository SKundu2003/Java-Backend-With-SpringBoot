package com.securityjpa.springsecurityusingjpa.Jpa_Repo;

import com.securityjpa.springsecurityusingjpa.DAO.UserDetailObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface UserReposetory extends JpaRepository<UserDetailObject, Integer> {

    //this will find in DB by the username
    public UserDetailObject findByUserName(String userName);

}
