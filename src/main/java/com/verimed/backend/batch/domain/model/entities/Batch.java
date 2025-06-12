package com.verimed.backend.batch.domain.model.entities;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="batch")
public class Batch {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private UUID code;

    @Column(name = "hash", nullable = false, unique = true)
    private String hash;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "certificateUrl")
    private String certificateUrl;

    public Batch(CreateBatchCommand command) {
        this.code = UUID.randomUUID();
        this.hash = command.hash();
        this.createdAt = LocalDateTime.now();
        this.certificateUrl = command.certificateUrl();
    }
}
