package com.verimed.backend.batch.application.internal.queryservice;

import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.model.queries.GetAllBatchesQuery;
import com.verimed.backend.batch.domain.model.queries.GetBatchByIdQuery;
import com.verimed.backend.batch.domain.service.BatchQueryService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;

import java.util.List;
import java.util.Optional;

public class BatchQueryServiceImpl implements BatchQueryService {
    private final BatchRepository batchRepository;
    public BatchQueryServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Optional<Batch> handle(GetBatchByIdQuery query) {
        return batchRepository.findById(query.id());
    }

    @Override
    public List<Batch> handle(GetAllBatchesQuery query) {
        return batchRepository.findAll();
    }
}
