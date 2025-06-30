package com.verimed.backend.tracking.domain.model.commands;

public record CloseTrackingCommand(Long trackingId) {
    public CloseTrackingCommand {
        if (trackingId == null || trackingId <= 0) {
            throw new IllegalArgumentException("Tracking ID must be a positive number.");
        }
    }
}
