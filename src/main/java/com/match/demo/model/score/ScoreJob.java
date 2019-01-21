package com.match.demo.model.score;

import com.match.demo.model.job.Job;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreJob implements Comparable<ScoreJob>{

    private double score;
    private Job job;

    public ScoreJob(double score, Job job) {
        this.score = score;
        this.job = job;
    }

    private double getRateInDouble(){
        return Double.parseDouble(job.getBillRate().replace("$",""));
    }

    @Override
    public int compareTo(ScoreJob o) {

        if( score > o.getScore())
            return -1;
        else if (score == o.getScore() && (getRateInDouble() > o.getRateInDouble()))
            return -1;
        else
            return 1;
    }
}
