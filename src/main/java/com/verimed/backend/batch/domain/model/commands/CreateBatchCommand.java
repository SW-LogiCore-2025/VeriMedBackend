package com.verimed.backend.batch.domain.model.commands;

import java.util.List;
import java.util.UUID;

public record CreateBatchCommand(
        String hash,
        List<Long>productSerialNumbers,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (hash == null || hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be null or empty");
        }
        if (productSerialNumbers == null || productSerialNumbers.isEmpty()) {
            throw new IllegalArgumentException("Its necessary to add product to the batch");
        }
    }

}
