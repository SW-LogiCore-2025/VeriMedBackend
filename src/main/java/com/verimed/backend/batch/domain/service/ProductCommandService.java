package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.model.aggregates.Product;
import java.util.List;

public interface ProductCommandService {
    List<Product> handle(AddProductToBatchCommand command);
}