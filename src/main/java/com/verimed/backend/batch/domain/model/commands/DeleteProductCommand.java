package com.verimed.backend.batch.domain.model.commands;

public record DeleteProductCommand(Long id){
    public DeleteProductCommand {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Product ID is not valid");
        }
    }
}
