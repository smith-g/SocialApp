package com.smithG.jobBoard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

    @RequestMapping(path = "/Comments", method = RequestMethod.GET)
    public String comments(){
        return "This is some Comments";
    }

}
