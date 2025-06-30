package com.verimed.backend.tracking.domain.model.commands;

public record CreateTrackingCommand(Long factoryId, Long batchId) {
    public CreateTrackingCommand {
        if (factoryId == null || batchId == null) {
            throw new IllegalArgumentException("Factory ID and Batch ID must not be null");
        }
    }
}
