package com.smithG.jobBoard.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Jobs {

    @RequestMapping("/jobs")
    public String getJobs() {
        return "jobs";
    }
}
