package com.verimed.backend.batch.Interface.rest.resources;

import com.verimed.backend.batch.domain.model.entities.Batch;
import java.time.LocalDate;

public record ProductResource(
        Long id,
        String name,
        String description,
        String image,
        Long serialNumber,
        Batch batch,
        Long productTypeId,
        String productTypeName,      // <-- Agregado
        String productTypeManufacturer, // <-- Agregado
        LocalDate manufactureDate,
        LocalDate expirationDate,
        String composition
) {
}