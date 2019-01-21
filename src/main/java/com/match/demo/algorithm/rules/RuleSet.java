package com.match.demo.algorithm.rules;

import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;

public abstract class RuleSet {

    protected Worker worker;
    protected Job job;
    protected double score = 0;

    public RuleSet(Worker worker, Job job){
        this.worker = worker;
        this.job = job;
    }

    /**
     * getScore
     * @return
     */
    public double getScore(){
        return score;
    }

    /**
     * reference : https://www.geodatasource.com/developers/java
     * 'M' is statute miles (default)
     * 'km' is kilometers
     * 'm' is ometers
     * 'N' is nautical miles
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @param unit
     * @return
     */
    protected double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit == "km") {
                dist = dist * 1.609344;
            }
            else if (unit == "m"){
                dist = dist * 1.609344 * 1000;
            } else if (unit == "N") {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
