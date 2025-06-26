package com.demo.JobPortal.Services;

import com.demo.JobPortal.Model.User;
import com.demo.JobPortal.Request.Login;
import com.demo.JobPortal.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements Userservice{
@Autowired
private UserRepo userrepo;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private HttpServletRequest request;
@Autowired
private AuthenticationManager autheticationmanager;
    @Override
    public User register(User user) {
        User user1=new User();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRoole(user.getRoole());
        User saved=userrepo.save(user1);
        return saved;
    }

    @Override
    public String signin(Login login) {
        try {
            System.out.println("wrong");
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());

            Authentication autheticat = autheticationmanager.authenticate(auth);

            SecurityContextHolder.getContext().setAuthentication(auth);
            request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
          System.out.println("wrog");
            return "Login successfull";

        }
        catch(Exception e){
            System.out.println("wrong");
            return "Invalid";
        }
    }
}
