package com.verimed.backend.batch.domain.model.commands;

import java.util.UUID;

public record CreateProductCommand(
        String name,
        String manufacturer
) {
    public CreateProductCommand {
        if (name == null || manufacturer == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
    }
}
