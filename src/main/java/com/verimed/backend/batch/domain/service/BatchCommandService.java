package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;

public interface BatchCommandService {
    void handle(CreateBatchCommand command);
}
