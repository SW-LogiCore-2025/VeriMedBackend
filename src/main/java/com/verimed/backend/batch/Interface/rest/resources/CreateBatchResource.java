package com.verimed.backend.batch.Interface.rest.resources;

import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateBatchResource(
        UUID code,
        String hash,
        LocalDateTime createdAt,
        List<CreateProductCommand> products,
        String certificateUrl
) {
    public CreateBatchResource {
        if (code == null || hash == null || createdAt == null || products == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (code.toString().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be empty");
        }
        if (hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
        if (createdAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("CreatedAt cannot be in the future");
        }
    }
}
