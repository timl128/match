package com.match.demo.exception;

public class WorkerNotFoundException extends RuntimeException {

    public WorkerNotFoundException(int workerId){
        super(String.format("WorkerId %s not found",workerId));
    }
}
