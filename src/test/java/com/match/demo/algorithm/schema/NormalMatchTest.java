package com.match.demo.algorithm.schema;

import com.match.demo.setup.DataSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class NormalMatchTest extends DataSetup {

    @InjectMocks
    private NormalMatch normalMatch;

    @Before
    public void setUp() throws IOException {
        super.setup();

    }

    @Test
    public void getScore() {

        double result = normalMatch.getScore(worker,job);
        assertThat(result,equalTo(5d));
    }
}