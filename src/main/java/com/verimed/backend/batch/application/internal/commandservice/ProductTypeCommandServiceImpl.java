package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import com.verimed.backend.batch.domain.model.commands.CreateProductTypeCommand;
import com.verimed.backend.batch.domain.service.ProductTypeCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeCommandServiceImpl implements ProductTypeCommandService {
    private final ProductTypeRepository productTypeRepository;
    public ProductTypeCommandServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public void handle(CreateProductTypeCommand command) {
        ProductType productType = new ProductType();
        productType.setName(command.name());
        productType.setManufacturer(command.manufacturer());
        productTypeRepository.save(productType);
    }
}
