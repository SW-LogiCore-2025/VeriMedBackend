package com.verimed.backend.tracking.domain.service;

import com.verimed.backend.tracking.domain.model.entities.Tracking;

public interface TrackingCommandService {
    Tracking createTracking(Long factoryId, Long batchId);
    Tracking updateTrackingWithBusinessId(Long trackingId, Long businessId);
    Tracking closeTracking(Long trackingId);
}
