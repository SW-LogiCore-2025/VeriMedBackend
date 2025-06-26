package com.verimed.backend.tracking.domain.model.entities;

import com.verimed.backend.batch.domain.model.entities.Batch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "batch_id", nullable = false)
    private Long batchId;

    @Column(name = "factory_id", nullable = false)
    private Long factoryId;

    @ElementCollection
    @CollectionTable(name = "tracking_business_entries", joinColumns = @JoinColumn(name = "tracking_id"))
    @Column(name = "business_id")
    private List<Long> businessIds = new ArrayList<>();

    @Column(name = "is_closed", nullable = false)
    private Boolean isClosed = false;

    public void addBusinessId(Long businessId) {
     this.businessIds.add(businessId);
    }

    public void closeSupplyChain(){
        this.isClosed = true;
    }
}
