package com.match.demo.controller;

import com.match.demo.model.job.Job;
import com.match.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchService matchService;

    /**
     * find best matches
     * @param id
     * @return
     */
    @GetMapping(value = "/find_jobs/worker/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Job> findJob(@PathVariable("id") int id){
        return matchService.getBestMatch(id);
    }
}
