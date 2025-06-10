package com.verimed.backend.batch.domain.model.commands;

public record CreateProductCommand(
        String name,
        String manufacturer,
        String batch
) {
    public CreateProductCommand {
        if (name == null || manufacturer == null || batch == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
        if (batch.isEmpty()) {
            throw new IllegalArgumentException("Batch cannot be empty");
        }
    }
}
