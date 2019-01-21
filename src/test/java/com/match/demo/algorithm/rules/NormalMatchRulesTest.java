package com.match.demo.algorithm.rules;

import com.match.demo.setup.DataSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class NormalMatchRulesTest extends DataSetup {

    private NormalMatchRules normalMatchRules;

    @Before
    public void setUp() throws IOException {
        super.setup();

        normalMatchRules = new NormalMatchRules(worker,job);

    }

    @Test
    public void driverLicenseScore() {

        assertThat(normalMatchRules.driverLicenseScore().getScore(),equalTo(0d));
    }

    @Test
    public void certificateScore() {
        assertThat(normalMatchRules.certificateScore().getScore(),equalTo(2d));
    }

    @Test
    public void userRatings() {
        assertThat(normalMatchRules.userRatings().getScore(),equalTo(2d));
    }

    @Test
    public void locationScore() {
        assertThat(normalMatchRules.locationScore().getScore(),equalTo(1d));
    }
}