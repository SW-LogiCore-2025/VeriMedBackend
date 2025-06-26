package com.verimed.backend.batch.domain.model.commands;

public record CreateBatchCommand(
        String name,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Hash cannot be null or empty");
        }
    }

}
