package com.verimed.backend.batch.domain.model.queries;

public record GetProductByIdQuery(Long id) {
    public GetProductByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }
}
