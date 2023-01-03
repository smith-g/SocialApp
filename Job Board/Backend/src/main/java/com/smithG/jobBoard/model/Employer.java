package com.smithG.jobBoard.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class Employer {


    @RequestMapping("/employer")
    public String getEmployer() {
        return "From Employer";
    }
}
