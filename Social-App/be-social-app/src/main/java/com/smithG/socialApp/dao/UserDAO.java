package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Users;

import java.util.List;
public interface UserDAO {


    List<Users> findUsersByUsername(String username);

    String findUsernameById(Long userId);

    Users getAccount(Long myId);
}
