package com.verimed.backend.batch.domain.model.aggregates;


import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "manufacturer", nullable = false, length = 100)
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    public Product(CreateProductCommand command, Batch batch) {
        this.name = command.name();
        this.manufacturer = command.manufacturer();
        this.batch = batch;
    }

    public Product(CreateProductCommand command) {
        this.name = command.name();
        this.manufacturer = command.manufacturer();
    }
}
