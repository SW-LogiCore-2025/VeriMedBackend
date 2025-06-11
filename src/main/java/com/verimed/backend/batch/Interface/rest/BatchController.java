package com.verimed.backend.batch.Interface.rest;

import com.verimed.backend.batch.Interface.rest.resources.BatchResource;
import com.verimed.backend.batch.Interface.rest.resources.CreateBatchResource;
import com.verimed.backend.batch.Interface.rest.transform.BatchResourceFromEntityAssembler;
import com.verimed.backend.batch.Interface.rest.transform.CreateBatchCommandFromResourceAssembler;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.domain.model.queries.GetAllBatchesQuery;
import com.verimed.backend.batch.domain.model.queries.GetBatchByIdQuery;
import com.verimed.backend.batch.domain.service.BatchCommandService;
import com.verimed.backend.batch.domain.service.BatchQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/batch", produces = MediaType.APPLICATION_JSON_VALUE)
public class BatchController {
    private final BatchCommandService batchCommandService;
    private final BatchQueryService batchQueryService;
    public BatchController(BatchCommandService batchCommandService, BatchQueryService batchQueryService) {
        this.batchCommandService = batchCommandService;
        this.batchQueryService = batchQueryService;
    }

    @PostMapping
    public ResponseEntity<BatchResource> createBatch(@RequestBody CreateBatchResource createBatchResource) {
        Optional<Batch> batchSource = batchCommandService.handle(CreateBatchCommandFromResourceAssembler.toCommand(createBatchResource));
        return batchSource.map(s -> new ResponseEntity<>(BatchResourceFromEntityAssembler
                        .toResourceFromEntity(s), HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<BatchResource>> getAllBatches() {
        List<Batch> batchSource = batchQueryService.handle(new GetAllBatchesQuery());
        var batchResources = batchSource
                .stream()
                .map(BatchResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(batchResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchResource> getBatchById(@PathVariable Long id) {
        Optional<Batch> batchSource = batchQueryService.handle(new GetBatchByIdQuery(id));
        return batchSource.map(s -> ResponseEntity
                        .ok(BatchResourceFromEntityAssembler
                        .toResourceFromEntity(s)))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
