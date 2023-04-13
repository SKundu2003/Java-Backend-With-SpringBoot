package com.securityjpa.springsecurityusingjpa.DAO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//to use Spring security with database --> need to impliment the "Useretails"
@Entity
public class UserDetailObject implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;

    private String authorities;

    public UserDetailObject(String userName, String password,String authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public UserDetailObject() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //we need to return List of generate authority
        List<GrantedAuthority> auth_list = new ArrayList<>();

        //from database we need to get roles --> in DB we stored roles as string, and seperate strings using ":"
        //so we need to Slpit all the roals and then convert then in "GrantedAuthority" type and store it in list
        String[] authority_array = this.authorities.split(":");

        //now convert and store in List
        for (int i = 0; i <authority_array.length ; i++) {
            //just bcz "GrantedAuthority" dont have constructor thats why we need to use "SimpleGrantedAuthority" class-->
            //--> to generate "GrantedAuthority" object
            GrantedAuthority obj = new SimpleGrantedAuthority(authority_array[i]);
            auth_list.add(obj);
        }
        return auth_list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //implementing some methods


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
