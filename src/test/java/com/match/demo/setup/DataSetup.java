package com.match.demo.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class DataSetup {

    protected Worker worker;
    protected Job job;

    public void setup() throws IOException {
        worker = new ObjectMapper()
                .readValue(new ClassPathResource("worker1.json").getFile(), Worker.class);

        job = new ObjectMapper()
                .readValue(new ClassPathResource("job1.json").getFile(), Job.class);
    }
}
