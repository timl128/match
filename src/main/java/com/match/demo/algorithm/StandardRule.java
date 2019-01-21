package com.match.demo.algorithm;

import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;
import org.springframework.stereotype.Component;

@Component
public class StandardRule implements Rule {

    @Override
    public double getScore(Worker worker, Job job) {
        return 0;
    }
}
