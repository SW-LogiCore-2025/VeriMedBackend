package com.verimed.backend.batch.application.internal.commandservice;

import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import com.verimed.backend.iam.domain.model.aggregates.User;
import com.verimed.backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BatchCommandServiceImpl implements BatchCommandService {
    private final BatchRepository batchRepository;
    private final UserRepository userRepository;

    public BatchCommandServiceImpl(BatchRepository batchRepository, UserRepository userRepository) {
        this.batchRepository = batchRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Batch handle(CreateBatchCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Batch batch = new Batch();
        batch.setCode(generateShortUUID());
        batch.setName(command.nameBatch());
        batch.setCreatedAt(LocalDateTime.now());
        batch.setCertificateUrl(command.certificateUrl());
        batch.setNameBatch(command.nameBatch());
        batch.setUser(user);
        return batchRepository.save(batch);
    }

    private String generateShortUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }
}