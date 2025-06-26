package com.verimed.backend.batch.Interface.rest.resources;

import java.util.List;

public record CreateBatchResource(
        String name,
        List<AddProductToBatchCommand> products,
        String certificateUrl
) {
    public CreateBatchResource {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be empty");
        }
    }
}
