package com.verimed.backend.tracking.infrastructure.persistence.jpa.repository;

import com.verimed.backend.tracking.domain.model.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    List<Tracking> findAllByFactoryId(Long factoryId);
    List<Tracking> findAllByBatchId(Long batchId);

}
