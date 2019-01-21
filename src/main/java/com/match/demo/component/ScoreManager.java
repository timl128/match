package com.match.demo.component;

import com.match.demo.algorithm.AlgorithmFactory;
import com.match.demo.algorithm.Schema;
import com.match.demo.model.job.Job;
import com.match.demo.model.score.ScoreJob;
import com.match.demo.model.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class ScoreManager {

    @Autowired
    private AlgorithmFactory algorithmFactory;

    /**
     * find score for each job
     * @return
     * @param worker
     * @param jobList
     */
    public Set<ScoreJob> getScoreForAllJobs(Worker worker, List<Job> jobList){

        Set<ScoreJob> scoreJobSet = new TreeSet<>();
        // get schema
        Schema schema = algorithmFactory.getRule("a");


        jobList.forEach(
                i -> {
                    double score = schema.getScore(worker,i);
                    scoreJobSet.add(new ScoreJob(score,i));
                }
        );

        return scoreJobSet;
    }
}
