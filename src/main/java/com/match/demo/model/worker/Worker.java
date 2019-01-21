package com.match.demo.model.worker;

import lombok.Data;

import java.util.List;

@Data
public class Worker {

    private String guid;
    private Double rating;
    private Boolean isActive;
    private List<String> certificates;
    private List<String> skills;
    private JobSearchAddress jobSearchAddress;
    private String transportation;
    private Boolean hasDriversLicense;
    private List<Availability> availability;
    private String phone;
    private String email;
    private Name name;
    private Integer age;
    private Integer userId;
}
