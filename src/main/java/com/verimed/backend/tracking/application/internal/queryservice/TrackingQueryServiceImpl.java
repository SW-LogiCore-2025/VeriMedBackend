package com.verimed.backend.tracking.application.internal.queryservice;

import com.verimed.backend.tracking.domain.model.entities.Tracking;
import com.verimed.backend.tracking.domain.service.TrackingQueryService;
import com.verimed.backend.tracking.infrastructure.persistence.jpa.repository.TrackingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingQueryServiceImpl implements TrackingQueryService {
    private final TrackingRepository trackingRepository;

    public TrackingQueryServiceImpl(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @Override
    public Optional<Tracking> getTrackingById(Long trackingId) {
        return trackingRepository.findById(trackingId);
    }

    @Override
    public List<Tracking> getTrackingsByFactoryId(Long factoryId) {
        return trackingRepository.findAllByFactoryId(factoryId);
    }

    @Override
    public List<Tracking> getTrackingsByBatchId(Long batchId) {
        return trackingRepository.findAllByBatchId(batchId);
    }
}
