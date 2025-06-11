package com.verimed.backend.batch.Interface.rest.resources;

import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BatchResource(
        UUID code,
        String hash,
        LocalDateTime createdAt,
        List<CreateProductCommand> products,
        String certificateUrl
) {
}
