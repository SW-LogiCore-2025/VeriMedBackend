package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.aggregates.ProductType;

import java.util.List;

public interface ProductTypeQueryService {
    List<ProductType> getAllProductTypes();
}
