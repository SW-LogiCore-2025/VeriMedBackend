package com.verimed.backend.batch.infrastructure.persistence.jpa.repository;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySerialNumberIn(List<Long> serialNumbers);
    @Query("SELECT MAX(p.serialNumber) FROM Product p WHERE p.name = :name AND p.manufacturer = :manufacturer")
    Integer findMaxSerialNumberByNameAndManufacturer(@Param("name") String name, @Param("manufacturer") String manufacturer);
}
