package com.smithG.socialApp.dao;

import com.smithG.socialApp.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDAO extends CrudRepository<Users, Long> {

    List<Users> findByEmail(String email);
}
