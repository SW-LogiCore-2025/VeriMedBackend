package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatchCommandServiceImpl implements BatchCommandService {
    private final BatchRepository batchRepository;
    private final ProductRepository productRepository;
    public BatchCommandServiceImpl(BatchRepository batchRepository, ProductRepository productRepository) {
        this.batchRepository = batchRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Batch> handle(CreateBatchCommand command) {
        var batch = new Batch(command);
        var products = productRepository.findAllBySerialNumberIn(command.productSerialNumbers());
        if (products.size() != command.productSerialNumbers().size()) {
            throw new IllegalArgumentException("Algunos productos no existen");
        }
        products.forEach(product -> product.assignBatch(batch.getCode()));
        productRepository.saveAll(products);
        var createdBatch = batchRepository.save(batch);
        return Optional.of(createdBatch);
    }
}
