package com.smithG.socialApp.controller;

import com.smithG.socialApp.model.Users;
import com.smithG.socialApp.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginDAO loginDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestBody Users users) {
        Users saveUser = null;
        ResponseEntity<String> response = null;

        try{
           String hashPwd = passwordEncoder.encode(users.getPwd());
           users.setPwd(hashPwd);
            saveUser = loginDAO.save(users);
            if(saveUser.getUser_id() > 0){
                response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully created");
            }
        }catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred due to " + ex.getMessage());
        }

            return response;
    }

}
