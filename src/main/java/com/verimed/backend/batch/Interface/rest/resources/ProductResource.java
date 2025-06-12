package com.verimed.backend.batch.Interface.rest.resources;

public record ProductResource (
        Long id,
        String serialNumber,
        String name,
        String manufacturer
){
}
