package com.verimed.backend.batch.domain.model.commands;


public record DeleteProductCommand(Long serialNumber){
    public DeleteProductCommand {
        if (serialNumber == null) {
            throw new IllegalArgumentException("Product serialNumber is not valid");
        }
    }
}
