package com.verimed.backend.batch.infrastructure.persistence.jpa.repository;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import com.verimed.backend.batch.domain.model.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
   List<Product> findByBatchCode(String batchCode);
    @Query("SELECT MAX(p.serialNumber) FROM Product p WHERE p.batch = :batch AND p.productType = :productType")
    Long findMaxSerialByBatchCodeAndProductTypeId(@Param("batch") Batch batch, @Param("productType") ProductType productType);

    List<Product> findByProductTypeId(Long productTypeId);
}
