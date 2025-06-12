package com.verimed.backend.batch.domain.model.commands;

import com.verimed.backend.batch.domain.model.aggregates.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateBatchCommand(
        String hash,
        List<CreateProductCommand>products,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
    }

}
