package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.model.queries.GetAllBatchesQuery;
import com.verimed.backend.batch.domain.model.queries.GetBatchByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BatchQueryService {
    Optional<Batch> handle(GetBatchByIdQuery getBatchByIdQuery);
    List<Batch> handle(GetAllBatchesQuery getAllBatchesQuery);
}
