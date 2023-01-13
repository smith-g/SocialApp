package com.smithG.jobBoard.securtiy;


import com.smithG.jobBoard.model.Users;
import com.smithG.jobBoard.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialAppUserDetails implements UserDetailsService {

    @Autowired
    UserDAO userDAO;


    @Override  
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       String eMail = null;
       String password = null;
       List<GrantedAuthority> authorities = null;
       List<Users> users = userDAO.findByEmail(email);

       if(users.size() == 0){
           throw new UsernameNotFoundException("User details not found for the user");
       }else {
           eMail = users.get(0).getEmail();
           password = users.get(0).getPwd();
           authorities = new ArrayList<>();
           authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
       }

       return new User(email, password, authorities);
    }
}
