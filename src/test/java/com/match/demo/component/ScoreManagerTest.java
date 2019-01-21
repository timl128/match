package com.match.demo.component;

import com.match.demo.algorithm.AlgorithmFactory;
import com.match.demo.algorithm.schema.NormalMatch;
import com.match.demo.model.job.Job;
import com.match.demo.model.score.ScoreJob;
import com.match.demo.model.worker.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ScoreManagerTest {

    @InjectMocks
    private ScoreManager scoreManager;

    @Mock
    private AlgorithmFactory algorithmFactory;;

    @Mock
    private NormalMatch normalMatch;

    @Test
    public void getScoreForAllJobs() {

        when(algorithmFactory.getRule(any())).thenReturn(normalMatch);

        Worker worker = new Worker();
        Job job1 = new Job(1,"$1");
        Job job2 = new Job(2, "$1.5");
        Job job3 = new Job(3, "$4");
        Job job4 = new Job(4, "$4");

        when(normalMatch.getScore(worker,job1)).thenReturn(60D);
        when(normalMatch.getScore(worker,job2)).thenReturn(40D);
        when(normalMatch.getScore(worker,job3)).thenReturn(40D);
        when(normalMatch.getScore(worker,job4)).thenReturn(40D);

        List<Job> jobList = Arrays.asList(job1,job2,job3,job4);

        Set<ScoreJob> set =
                scoreManager.getScoreForAllJobs(worker,jobList);
        ScoreJob[] scoreJobs= set.toArray(new ScoreJob[set.size()]);
        assertThat(scoreJobs[0].getJob().getJobId(),equalTo(1));
        assertThat(scoreJobs[1].getJob().getJobId(),equalTo(3));
        assertThat(scoreJobs[2].getJob().getJobId(),equalTo(4));
        assertThat(scoreJobs[3].getJob().getJobId(),equalTo(2));
    }
}