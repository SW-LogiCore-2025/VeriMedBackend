package com.verimed.backend.batch.infrastructure.persistence.jpa.repository;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsById(Long id);
    boolean existsByBatchCode(UUID batchCode);
    List<Product> findAllByBatchCode(UUID batchCode);
    List<Product> findAllBySerialNumberIn(List<UUID> serialNumbers);
}
