package com.verimed.backend.batch.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="batch")
public class Batch {
    @Id
    @Column(name = "code", nullable = false, unique = true, length = 12)
    private String code;

    @Column(name = "hash", nullable = false, unique = true)
    private String hash;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "certificateUrl")
    private String certificateUrl;

    @Column(name = "nameBatch")
    private String nameBatch;
}
