package com.match.demo.service;

import com.match.demo.exception.WorkerNotFoundException;
import com.match.demo.model.job.Job;
import com.match.demo.model.worker.Worker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    /**
     * find worker
     * @param workerId
     * @return
     */
    public Worker findWorker(int workerId){

        RestTemplate restTemplate = new RestTemplate();
        Worker[] workers = restTemplate.getForObject("http://test.swipejobs.com/api/workers", Worker[].class);

        for(Worker w : workers){
            if(w.getUserId().equals(workerId))
                return w;
        }
        throw new WorkerNotFoundException(workerId);
    }

    /**
     * get list of jobs
     * @return
     */
    public List<Job> getJobs(){

        RestTemplate restTemplate = new RestTemplate();
        Job[] jobs = restTemplate.getForObject("http://test.swipejobs.com/api/jobs", Job[].class);
        return Arrays.asList(jobs);
    }
}
