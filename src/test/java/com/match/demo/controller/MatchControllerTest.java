package com.match.demo.controller;

import com.match.demo.model.job.Job;
import com.match.demo.service.MatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class MatchControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MatchService matchService;

    @Test
    public void findJob()  throws Exception{

        List<Job> jobList = new ArrayList<>();
        when(matchService.getBestMatch(1)).thenReturn(jobList);

        mvc.perform(get("/find_jobs/worker/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}