package com.verimed.backend.batch.infrastructure.persistence.jpa.repository;

import com.verimed.backend.batch.domain.model.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepository extends JpaRepository<Batch, String> {
    List<Batch> findByUserId(Long userId);
}
