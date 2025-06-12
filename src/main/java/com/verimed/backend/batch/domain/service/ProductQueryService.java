package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.aggregates.Product;

import java.util.List;

public interface ProductQueryService {
    List<Product> getProductsByBatch(String batchCode);
}
