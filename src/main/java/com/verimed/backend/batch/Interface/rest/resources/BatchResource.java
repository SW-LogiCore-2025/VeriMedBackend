package com.verimed.backend.batch.Interface.rest.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BatchResource(
        UUID code,
        String hash,
        LocalDateTime createdAt,
        List<com.verimed.backend.batch.domain.model.aggregates.Product> products,
        String certificateUrl
) {
}
