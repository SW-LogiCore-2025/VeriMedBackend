package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductRepository;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final ProductTypeRepository productTypeRepository;
    public ProductCommandServiceImpl(ProductRepository productRepository, BatchRepository batchRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public List<Product> handle(AddProductToBatchCommand command) {
        Optional<Batch> batchOpt = batchRepository.findById(command.batchCode());
        Optional<ProductType> productTypeOpt = productTypeRepository.findById(command.productTypeId());

        if (batchOpt.isEmpty() || productTypeOpt.isEmpty()) {
            throw new IllegalArgumentException("Batch or Product Type not found");
        }

        Batch batch = batchOpt.get();
        ProductType productType = productTypeOpt.get();

        Long maxSerial = productRepository.findMaxSerialByBatchCodeAndProductTypeId(batch, productType);
        if (maxSerial == null) maxSerial = 0L;

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < command.quantity(); i++) {
            Product product = new Product();
            product.setBatch(batch);
            product.setProductType(productType);
            product.setSerialNumber(maxSerial + i);
            products.add(product);
        }
        productRepository.saveAll(products);
        return products;
    }
}
