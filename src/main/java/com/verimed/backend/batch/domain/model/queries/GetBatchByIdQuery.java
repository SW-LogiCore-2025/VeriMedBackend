package com.verimed.backend.batch.domain.model.queries;

public record GetBatchByIdQuery(Long id) {
    public GetBatchByIdQuery {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }
}
