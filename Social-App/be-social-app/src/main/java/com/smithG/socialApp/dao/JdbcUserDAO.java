package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDAO implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Users> findUsersByUsername(String username) {
        String sql = "SELECT username FROM users where username = ?";
        List<Users> users = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while(results.next()){
            Users user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public String findUsernameById(Long userId) {
        String sql = "select username from users where user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if(results.next()){
            return mapRowToUser(results).getUsername();
        }else {
            throw new UsernameNotFoundException("the user does not exsit");
        }
    }

    @Override
    public Users getAccount(Long myId) {
        return null;
    }


    private Users mapRowToUser(SqlRowSet rs){
        Users users = new Users();
        users.setUser_id(rs.getLong("user_id"));
        users.setEmail(rs.getNString("email"));
        users.setUsername(rs.getNString("username"));
        users.setPwd(rs.getNString("pwd"));
        users.setRole(rs.getNString("role"));
        return users;
    }
}
