package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.entities.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchQueryService {
    List<Batch> getAllBatches();
    Optional<Batch> getBatchByCode(String code);
}
