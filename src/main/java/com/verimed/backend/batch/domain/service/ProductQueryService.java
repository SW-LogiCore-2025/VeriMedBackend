package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.aggregates.Product;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    List<Product> getProductsByBatch(String batchCode);
    Optional<Product> getProductById(Long id);
    List<Product> getProductsByProductType(Long productTypeId);
    Optional<Product> getProductBySerialNumber(String serialNumber);


}
