package com.verimed.backend.batch.application.internal.queryservice;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.queries.GetAllProductsByBatchCodeQuery;
import com.verimed.backend.batch.domain.model.queries.GetProductByIdQuery;
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
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.id());
    }

    @Override
    public List<Product> handle(GetAllProductsByBatchCodeQuery query) {
        return productRepository.findAll();
    }
}
