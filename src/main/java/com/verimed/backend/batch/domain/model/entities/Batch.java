package com.verimed.backend.batch.domain.model.entities;

import com.verimed.backend.iam.domain.model.aggregates.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="batch")
public class Batch {
    @Id
    @Column(name = "code", nullable = false, unique = true, length = 12)
    private String code;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "certificateUrl")
    private String certificateUrl;

    @Column(name = "nameBatch")
    private String nameBatch;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}