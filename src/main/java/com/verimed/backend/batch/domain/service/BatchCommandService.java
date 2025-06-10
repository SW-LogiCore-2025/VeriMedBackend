package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;

import java.util.Optional;

public interface BatchCommandService {
    Optional<Batch> handle(CreateBatchCommand createBatchCommand);
}
