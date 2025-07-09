package com.verimed.backend.batch.application.internal.queryservice;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.service.ProductQueryService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;
    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProductsByBatch(String batchCode) {
        return productRepository.findByBatchCode(batchCode);
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> getProductsByProductType(Long productTypeId) {
        return productRepository.findByProductTypeId(productTypeId);
    }
}
