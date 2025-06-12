package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;
import com.verimed.backend.batch.domain.model.commands.DeleteProductCommand;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {
    private final ProductRepository productRepository;
    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(CreateProductCommand command) {
        Integer maxSerial = productRepository.findMaxSerialNumberByNameAndManufacturer(
                command.name(), command.manufacturer()
        );
        Long nextSerial = (maxSerial == null) ? 1L : maxSerial + 1L;
        var product = new Product(command.name(), command.manufacturer(), nextSerial);
        var createdProduct = productRepository.save(product);
        return Optional.of(createdProduct);
    }

    @Override
    public void handle(DeleteProductCommand command){
       var id = command.id();
         if (!productRepository.existsById(id)) {
              throw new IllegalArgumentException("Product with serial number " + id + " does not exist.");
         }
         productRepository.deleteById(id);
    }
}
