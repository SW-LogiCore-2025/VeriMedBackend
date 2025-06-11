package com.verimed.backend.batch.Interface.rest.resources;

public record CreateProductResource(
        String name,
        String manufacturer,
        String batch
) {
    public CreateProductResource {
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
