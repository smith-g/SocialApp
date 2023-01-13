package com.smithG.jobBoard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String post() {
        return "This is some post";
    }

}
