package com.smithG.socialApp.controller;

import com.smithG.socialApp.dao.CommnetsDao;
import com.smithG.socialApp.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    private CommnetsDao commnetsDao;

    @Autowired
    public CommentsController(CommnetsDao commnetsDao) {
        this.commnetsDao = commnetsDao;
    }

    @RequestMapping(path = "/comment/user={userId}", method = RequestMethod.GET)
    public List<Comments> repliesByUser(@PathVariable Long userId){
        return commnetsDao.repliesByUser(userId);
    }

    @RequestMapping(path = "/comments/post={postId}", method = RequestMethod.GET)
    public List<Comments> commentsByPost(@PathVariable Long postId){
        return commnetsDao.commentsByPost(postId);
    }

    @RequestMapping(path = "/comment/{commentsId}", method = RequestMethod.GET)
    public Comments findCommentsById(@PathVariable Long commentId){
        return commnetsDao.findCommentById(commentId);
    }


    public ResponseEntity<Comments> addComments(@RequestBody Comments comments){
        Comments comment = commnetsDao.addComment(comments);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

}
