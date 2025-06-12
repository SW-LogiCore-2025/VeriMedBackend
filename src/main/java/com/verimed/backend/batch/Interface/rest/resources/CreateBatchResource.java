package com.verimed.backend.batch.Interface.rest.resources;

import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateBatchResource(
        String hash,
        List<CreateProductCommand> products,
        String certificateUrl
) {
    public CreateBatchResource {
        if (hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
    }
}
