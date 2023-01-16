package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcUserDAO implements UserDAO {

    @Override
    public List<Users> findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<Users> findUserById(Long userId) {
        return null;
    }
}
