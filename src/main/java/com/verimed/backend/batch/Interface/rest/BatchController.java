package com.verimed.backend.batch.Interface.rest;

import com.verimed.backend.batch.Interface.rest.resources.BatchResource;
import com.verimed.backend.batch.Interface.rest.transform.BatchResourceFromEntityAssembler;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.domain.service.BatchQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/verimed/batch", produces = MediaType.APPLICATION_JSON_VALUE)
public class BatchController {
    private final BatchCommandService batchCommandService;
    private final BatchQueryService batchQueryService;

    public BatchController(BatchCommandService batchCommandService, BatchQueryService batchQueryService) {
        this.batchCommandService = batchCommandService;
        this.batchQueryService = batchQueryService;
    }

    @PostMapping
    public ResponseEntity<Void> createBatch(@RequestBody CreateBatchCommand command) {
        batchCommandService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<BatchResource> getAllBatches() {
        return batchQueryService.getAllBatches()
                .stream()
                .map(BatchResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}