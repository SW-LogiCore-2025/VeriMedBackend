package com.verimed.backend.batch.Interface.rest.resources;

import java.time.LocalDate;


public record AddProductToBatchCommand(
        String batchCode,
        Long productTypeId,
        Integer quantity,
        String name,
        String description,
        String image,
        String composition
) {
    public AddProductToBatchCommand {
        if (batchCode == null || batchCode.isBlank()) {
            throw new IllegalArgumentException("Batch code cannot be null or empty");
        }
        if (productTypeId == null || productTypeId <= 0) {
            throw new IllegalArgumentException("Product type ID must be a positive number");
        }
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (composition == null || composition.isBlank()) {
            throw new IllegalArgumentException("Composition cannot be null or empty");
        }
    }
}