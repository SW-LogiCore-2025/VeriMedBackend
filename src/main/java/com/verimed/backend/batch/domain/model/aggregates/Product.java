package com.verimed.backend.batch.domain.model.aggregates;


import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="serial_number", nullable = false, unique = true)
    private UUID serialNumber;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "manufacturer", nullable = false, length = 100)
    private String manufacturer;

    @JoinColumn(name = "batch_code")
    private UUID batchCode;

    public Product(CreateProductCommand command) {
        this.serialNumber = UUID.randomUUID();
        this.name = command.name();
        this.manufacturer = command.manufacturer();
        this.batchCode = null;
    }

    public void assignBatch(UUID batchCode) {
        this.batchCode = batchCode;
    }
}
