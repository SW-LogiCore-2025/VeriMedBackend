package com.verimed.backend.batch.domain.model.commands;

public record CreateProductTypeCommand(
        String name,
        String manufacturer
) {

    public CreateProductTypeCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Manufacturer cannot be null or blank");
        }
    }
}
