package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BatchCommandServiceImpl implements BatchCommandService {
    private final BatchRepository batchRepository;

    public BatchCommandServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public void handle(CreateBatchCommand command) {
        Batch batch = new Batch();
        batch.setCode(generateShortUUID());
        batch.setName(command.nameBatch());
        batch.setCreatedAt(LocalDateTime.now());
        batch.setCertificateUrl(command.certificateUrl());
        batch.setNameBatch(command.nameBatch());
        batchRepository.save(batch);
    }

    private String generateShortUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }
}
