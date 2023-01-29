package com.smithG.socialApp.controller;

import com.smithG.socialApp.dao.PostDao;
import com.smithG.socialApp.model.Posts;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private final PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public List<Posts> getAllPosts(){
        return postDao.getAllPosts();
    }

    @RequestMapping(path = "/post/{userId}", method = RequestMethod.GET)
    public List<Posts> getUserPosts(@PathVariable long userid) {
        return  postDao.findPostsByUserId(userid);
    }


    @RequestMapping(path = "/post/{postId}", method = RequestMethod.GET)
    public Posts getPostById(@PathVariable long postId){
        return postDao.findPostById(postId);
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public ResponseEntity<Posts> addPost(@RequestBody Posts posts) {
      Posts posts1 =   postDao.addPost(posts);
      return new ResponseEntity<>(posts1, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/deletepost/{postId}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable long postId){
        postDao.deletePost(postId);
    }

}
