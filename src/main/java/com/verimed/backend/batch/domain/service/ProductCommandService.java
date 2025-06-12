package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;

public interface ProductCommandService {
    void handle(AddProductToBatchCommand command);
}
