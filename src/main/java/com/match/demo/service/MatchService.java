package com.match.demo.service;

import com.match.demo.component.ScoreManager;
import com.match.demo.exception.WorkerNotFoundException;
import com.match.demo.model.job.Job;
import com.match.demo.model.score.ScoreJob;
import com.match.demo.model.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class MatchService {

    @Autowired
    private ScoreManager scoreManager;

    @Autowired
    private ApiService apiService;

    private static final int MAX_JOB = 3;

    /**
     * get best 3 match
     * @param workerId
     * @return
     */
    public List<Job> getBestMatch(int workerId){


        Worker worker = apiService.findWorker(workerId);
        List<Job> jobList = apiService.getJobs();

        Set<ScoreJob> result = scoreManager.getScoreForAllJobs(worker,jobList);

        return getTopJobs(result);
    }

    private List<Job> getTopJobs(Set<ScoreJob> result){

        List<Job> topJob = new LinkedList<>();
        int count = 0;

        for (ScoreJob scoreJob : result){

            if(count == MAX_JOB)
                break;;

            topJob.add(scoreJob.getJob());
            count++;
        }

        return topJob;
    }
}
