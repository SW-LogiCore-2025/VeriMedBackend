package com.verimed.backend.tracking.Interface.rest.resources;

import java.util.List;

public record CreateTrackingResource (
        Long batchId,
        Long factoryId
){
    public CreateTrackingResource {
        if (batchId == null || batchId <= 0) {
            throw new IllegalArgumentException("Batch ID must be a positive number");
        }
        if (factoryId == null || factoryId <= 0) {
            throw new IllegalArgumentException("Factory ID must be a positive number");
        }
    }
}
