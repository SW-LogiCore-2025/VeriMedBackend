package com.verimed.backend.batch.application.internal.queryservice;

import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import com.verimed.backend.batch.domain.service.ProductTypeQueryService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeQueryServiceImpl implements ProductTypeQueryService {
    private final ProductTypeRepository productTypeRepository;
    public ProductTypeQueryServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
