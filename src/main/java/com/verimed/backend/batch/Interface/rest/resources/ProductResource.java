package com.verimed.backend.batch.Interface.rest.resources;

public record ProductResource (
        String name,
        String manufacturer,
        com.verimed.backend.batch.domain.model.entities.Batch batch
){
}
