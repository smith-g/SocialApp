package com.smithG.jobBoard.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobSeeker {

    @RequestMapping("/job-seeker")
    public String getJobSeeker() {
        return "Smith";
    }
}
