package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.CreateProductTypeCommand;

public interface ProductTypeCommandService {
    void handle(CreateProductTypeCommand command);
}
