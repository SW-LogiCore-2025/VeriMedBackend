package com.verimed.backend.tracking.application.internal.commandservice;

import com.verimed.backend.tracking.domain.model.entities.Tracking;
import com.verimed.backend.tracking.domain.service.TrackingCommandService;
import com.verimed.backend.tracking.infrastructure.persistence.jpa.repository.TrackingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TrackingCommandServiceImpl implements TrackingCommandService {
    private final TrackingRepository trackingRepository;

    public TrackingCommandServiceImpl(TrackingRepository trackingRepository) {
        this.trackingRepository = trackingRepository;
    }

    @Override
    @Transactional
    public Tracking createTracking(Long factoryId, Long batchId) {
        Tracking tracking = new Tracking();
        tracking.setFactoryId(factoryId);
        tracking.setBatchId(batchId);
        return trackingRepository.save(tracking);
    }

    @Override
    @Transactional
    public Tracking updateTrackingWithBusinessId(Long trackingId, Long businessId) {
        Tracking tracking = trackingRepository.findById(trackingId)
                .orElseThrow(() -> new IllegalArgumentException("Tracking no encontrado"));
        tracking.addBusinessId(businessId);
        return trackingRepository.save(tracking);
    }

    @Override
    @Transactional
    public Tracking closeTracking(Long trackingId) {
        Tracking tracking = trackingRepository.findById(trackingId)
                .orElseThrow(() -> new IllegalArgumentException("Tracking no encontrado"));
        tracking.closeSupplyChain();
        return trackingRepository.save(tracking);
    }
}
