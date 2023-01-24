package com.smithG.socialApp.controller;

import com.smithG.socialApp.dao.PostDao;
import com.smithG.socialApp.model.Posts;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class PostController {

    @Autowired
    private final PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String post() {
        return "This is some post";
    }

    @PermitAll
    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public ResponseEntity<Posts> addPost(@RequestBody Posts posts) {
      Posts posts1 =   postDao.addPost(posts);
      return new ResponseEntity<>(posts1, HttpStatus.CREATED);
    }

}
