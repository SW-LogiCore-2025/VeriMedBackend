package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;

public interface BatchCommandService {
    Batch handle(CreateBatchCommand command);
}
