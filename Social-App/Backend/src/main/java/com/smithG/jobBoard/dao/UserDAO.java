package com.smithG.jobBoard.dao;

import com.smithG.jobBoard.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<Users, Long> {

    List<Users> findByEmail(String email);

    String findByUsername(String username);
}
