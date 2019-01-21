package com.match.demo.algorithm;

import com.match.demo.algorithm.schema.NormalMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlgorithmFactory {

    @Autowired
    private NormalMatch normalMatch;

    public Schema getRule(String name){

        switch (name){
            default:
                return normalMatch;
        }

    }
}
