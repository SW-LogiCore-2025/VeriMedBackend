package com.verimed.backend.batch.domain.model.queries;


public record GetProductBySerialNumberQuery(Long serialNumber) {
    public GetProductBySerialNumberQuery {
        if (serialNumber == null) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }
}
