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
        var product = new Product(command);
        var createdProduct = productRepository.save(product);
        return Optional.of(createdProduct);
    }

    @Override
    public void handle(DeleteProductCommand command){
        if(!productRepository.existsById(command.id())) throw new IllegalArgumentException("Product not found");
        try {
            productRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting product");
        }
    }
}
