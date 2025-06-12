package com.verimed.backend.batch.Interface.rest.resources;

import java.util.List;

public record CreateBatchResource(
        String hash,
        List<AddProductToBatchCommand> products,
        String certificateUrl
) {
    public CreateBatchResource {
        if (hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
    }
}
