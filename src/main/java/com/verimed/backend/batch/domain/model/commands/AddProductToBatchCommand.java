package com.verimed.backend.batch.domain.model.commands;

import java.time.LocalDate;

public record AddProductToBatchCommand(
        String batchCode,
        Long productTypeId,
        int quantity,
        String name,
        String description,
        String image,
        LocalDate manufactureDate,
        LocalDate expirationDate,
        String composition
) {
}