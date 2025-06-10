package com.verimed.backend.batch.domain.model.aggregates;


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
    @Column(name = "batch_id")
    private Batch batch;
}
