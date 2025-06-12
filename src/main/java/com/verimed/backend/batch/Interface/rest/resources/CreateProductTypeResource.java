package com.verimed.backend.batch.Interface.rest.resources;

public record CreateProductTypeResource(
        String name,
        String manufacturer
) {
    public CreateProductTypeResource {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (manufacturer == null || manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be blank");
        }
    }
}
