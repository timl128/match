package com.match.demo.model.job;

import com.match.demo.model.common.Location;
import lombok.Data;

import java.util.List;

@Data
public class Job {

    private Boolean driverLicenseRequired;
    private List<String> requiredCertificates;
    private Location location;
    private String billRate;
    private Integer workersRequired;
    private String startDate;
    private String about;
    private String jobTitle;
    private String company;
    private String guid;
    private Integer jobId;

    public Job() {
    }

    public Job(Integer id , String rate){
        this.jobId = id;
        this.billRate = rate;
    }
}
