package com.verimed.backend.batch.Interface.rest.resources;

public record AddProductToBatchCommand(
        String batchCode,
        Long productTypeId,
        Integer quantity
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
    }
}
