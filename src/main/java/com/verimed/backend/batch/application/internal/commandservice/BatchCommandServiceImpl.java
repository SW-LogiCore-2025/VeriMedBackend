package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;

import java.util.Optional;

public class BatchCommandServiceImpl implements BatchCommandService {
    private final BatchRepository batchRepository;
    public BatchCommandServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public Optional<Batch> handle(CreateBatchCommand command) {
        var batch = new Batch(command);
        var createdBatch = batchRepository.save(batch);
        return Optional.of(createdBatch);
    }
}
