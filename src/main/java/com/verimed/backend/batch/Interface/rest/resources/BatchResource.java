package com.verimed.backend.batch.Interface.rest.resources;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record BatchResource(
        String code,
        String hash,
        LocalDateTime createdAt,
        List<ProductResource> products,
        String certificateUrl
) {
}
