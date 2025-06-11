package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;
import com.verimed.backend.batch.domain.model.commands.DeleteProductCommand;

import java.util.Optional;

public interface ProductCommandService {
    Optional<Product> handle(CreateProductCommand createProductCommand);
    void handle(DeleteProductCommand deleteProductCommand);
}
