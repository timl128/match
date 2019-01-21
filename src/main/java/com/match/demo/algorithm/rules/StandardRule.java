package com.match.demo.algorithm.rules;


public interface StandardRule<T>{

    double ONE_MATCH_SCORE = 1;

    /**
     * license score
     * @return
     */
    T driverLicenseScore();

    /**
     * certificates score
     * @return
     */
    T certificateScore();

    /**
     * worker ratings score
     * @return
     */
    T userRatings();

    /**
     * location score
     * @return
     */
    T locationScore();
}
