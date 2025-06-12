package com.verimed.backend.batch.Interface.rest.resources;

import com.verimed.backend.batch.domain.model.entities.Batch;

public record ProductResource (
        Long id,
        String serialNumber,
        Batch name,
        String manufacturer
){
}
