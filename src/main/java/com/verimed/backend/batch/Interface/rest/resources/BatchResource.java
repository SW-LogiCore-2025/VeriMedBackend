package com.verimed.backend.batch.Interface.rest.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BatchResource(
        String code,
        String name,
        LocalDateTime createdAt,
        List<ProductResource> products,
        String certificateUrl,
        String nameBatch,
        Long userId
) {
}
