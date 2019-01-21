package com.match.demo.algorithm.schema;

import com.match.demo.algorithm.Schema;
import com.match.demo.algorithm.rules.NormalMatchRules;
import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;
import org.springframework.stereotype.Component;


@Component
public class NormalMatch implements Schema {

    @Override
    public double getScore(Worker worker, Job job) {

        NormalMatchRules rulesSet = new NormalMatchRules(worker,job);

        return rulesSet.certificateScore()
                .driverLicenseScore().locationScore().userRatings().getScore();
    }

}
