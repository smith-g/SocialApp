package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserDAO {


    List<Users> findUserByUsername(String username);

    List<Users> findUserById(Long userId);
}
