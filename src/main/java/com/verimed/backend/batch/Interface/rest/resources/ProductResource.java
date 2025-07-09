package com.verimed.backend.batch.Interface.rest.resources;

import java.time.LocalDate;

public record ProductResource(
        Long id,
        String name,
        String description,
        String image,
        String serialNumber,
        String batchCode, // Solo el código del batch
        Long productTypeId,
        String productTypeName,
        String productTypeManufacturer,
        LocalDate manufactureDate,
        LocalDate expirationDate,
        String composition,
        String qrCodeBase64
) {
}