package com.smithG.socialApp.controller;

import com.smithG.socialApp.dao.UserDAO;
import com.smithG.socialApp.model.Users;
import org.apache.catalina.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final UserDAO userDAO;


    public AccountController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path = "/findusers/{username}", method = RequestMethod.GET)
    public List<Users> findUsers(@PathVariable String username){
        return userDAO.findUsersByUsername(username);
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String findUsername(@PathVariable Long userId){
        return userDAO.findUsernameById(userId);
    }

}
