package com.match.demo.algorithm.rules;

import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;


public class NormalMatchRules extends RuleSet implements StandardRule<NormalMatchRules> {


    public NormalMatchRules(Worker worker, Job job) {
        super(worker, job);
    }

    @Override
    public NormalMatchRules driverLicenseScore() {

        if(worker.getHasDriversLicense() && job.getDriverLicenseRequired())
            addScore(ONE_MATCH_SCORE);
        return this;
    }

    /**
     * O(n^2)
     * @return
     */
    @Override
    public NormalMatchRules certificateScore() {

        long match = worker.getCertificates().stream() .filter(job.getRequiredCertificates()::contains)
                .count();
        addScore(match * ONE_MATCH_SCORE);
        return this;
    }

    @Override
    public NormalMatchRules userRatings() {

        addScore(worker.getRating() * ONE_MATCH_SCORE);
        return this;
    }

    @Override
    public NormalMatchRules locationScore() {

        double distance = distance(
                worker.getJobSearchAddress().getLatitude(),
                worker.getJobSearchAddress().getLongitude(),
                job.getLocation().getLatitude(),
                job.getLocation().getLongitude(),
                worker.getJobSearchAddress().getUnit()
        );

        if(distance <= worker.getJobSearchAddress().getMaxJobDistance())
            addScore( ONE_MATCH_SCORE);

        return this;
    }


    /**
     * add score
     * @param value
     */
    private void addScore(double value){
        score = score + value;
    }
}
