package com.verimed.backend.batch.Interface.rest.resources;

import java.util.UUID;

public record ProductResource (
        String name,
        String manufacturer,
        UUID batchCode
){
}
