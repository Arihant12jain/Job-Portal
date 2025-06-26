package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class CustomUserDetails implements UserDetailsService{
@Autowired
private UserRepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userrepo.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoole())
        );


    }
}
