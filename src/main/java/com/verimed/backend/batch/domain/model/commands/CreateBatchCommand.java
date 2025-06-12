package com.verimed.backend.batch.domain.model.commands;

public record CreateBatchCommand(
        String hash,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (hash == null || hash.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be null or empty");
        }
    }

}
