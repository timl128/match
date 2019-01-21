package com.match.demo.algorithm;

import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;

public interface Rule {

    /**
     * get score for each job
     * @param worker
     * @param job
     * @return
     */
    double getScore(Worker worker, Job job);
}
