package com.verimed.backend.batch.infrastructure.persistence.jpa.repository;

import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
