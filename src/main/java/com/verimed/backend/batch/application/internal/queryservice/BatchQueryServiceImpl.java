package com.verimed.backend.batch.application.internal.queryservice;

import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.BatchQueryService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchQueryServiceImpl implements BatchQueryService {
    private final BatchRepository batchRepository;
    public BatchQueryServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }


    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<Batch> getBatchByCode(String code) {
        return batchRepository.findById(code);
    }

    @Override
    public List<Batch> getBatchesByUserId(Long userId) {
        return batchRepository.findByUserId(userId);
    }
}
