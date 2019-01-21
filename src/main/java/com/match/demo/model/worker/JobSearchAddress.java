package com.match.demo.model.worker;

import com.match.demo.model.common.Location;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class JobSearchAddress extends Location {

    private String unit;
    private Double maxJobDistance;
}
