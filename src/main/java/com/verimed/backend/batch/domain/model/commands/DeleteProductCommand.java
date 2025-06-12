package com.verimed.backend.batch.domain.model.commands;


public record DeleteProductCommand(Long id){
    public DeleteProductCommand {
        if (id == null) {
            throw new IllegalArgumentException("Product serialNumber is not valid");
        }
    }
}
