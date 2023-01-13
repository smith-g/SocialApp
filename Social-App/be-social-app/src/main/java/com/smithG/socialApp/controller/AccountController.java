package com.smithG.jobBoard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public String account() {
        return "This is my account";
    }
}
