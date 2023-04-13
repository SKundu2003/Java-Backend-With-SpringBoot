package com.JWT_BootCamp.JWT.Filter;

import com.JWT_BootCamp.JWT.Services.CustomUserServices;
import com.JWT_BootCamp.JWT.Util.JwtUtil;
import org.apache.catalina.security.SecurityClassLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration

//call this filter for only once for per request
public class JwtAuthenticationFilter extends OncePerRequestFilter {//use to --> Validate the token

    //to validate the token
    @Autowired
    private CustomUserServices customUserServices;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //get the JWT token from request Header
        //and validate the token
        String bearToken = request.getHeader("Authorization");
        String userName = null;
        String token = null;

        //check if token exist or has Bearer text
        if(bearToken!=null && bearToken.startsWith("Bearer ")){

            //extract jwt token from Bearer token
            token = bearToken.substring(7);
            try {
                //extrackets username from the token
                userName = jwtUtil.extractUsername(token);

                //gets userdetails from the userName
                UserDetails userDetails = customUserServices.loadUserByUsername(userName);

                //security check
                if (userName != null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(upat);


                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
            filterChain.doFilter(request,response);

            //now set the filter in Config
        }
    }
}
