package com.verimed.backend.batch.domain.model.commands;

import com.verimed.backend.batch.domain.model.aggregates.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateBatchCommand(
        UUID code,
        String hash,
        LocalDateTime createdAt,
        List<Product>products,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (code == null || hash == null || createdAt == null || products == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (code.toString().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be empty");
        }
        if (hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("CreatedAt cannot be null");
        }
        if (createdAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("CreatedAt cannot be in the future");
        }
    }

}
