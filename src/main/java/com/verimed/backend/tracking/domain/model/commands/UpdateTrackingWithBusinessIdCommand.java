package com.verimed.backend.tracking.domain.model.commands;

public record UpdateTrackingWithBusinessIdCommand(Long trackingId, Long businessId) {
    public UpdateTrackingWithBusinessIdCommand {
        if (trackingId == null || trackingId <= 0) {
            throw new IllegalArgumentException("Tracking ID must be a positive number.");
        }
        if (businessId == null || businessId <= 0) {
            throw new IllegalArgumentException("Business ID must be a positive number.");
        }
    }
}
