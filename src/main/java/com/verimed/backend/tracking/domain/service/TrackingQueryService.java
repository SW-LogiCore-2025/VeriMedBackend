package com.verimed.backend.tracking.domain.service;

import com.verimed.backend.tracking.domain.model.entities.Tracking;

import java.util.List;
import java.util.Optional;

public interface TrackingQueryService {
    Optional<Tracking> getTrackingById(Long trackingId);
    List<Tracking> getTrackingsByFactoryId(Long factoryId);
    List<Tracking> getTrackingsByBatchId(Long batchId);}
