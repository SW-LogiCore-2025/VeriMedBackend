package com.verimed.backend.tracking.Interface.rest;

import com.verimed.backend.tracking.Interface.rest.resources.CreateTrackingResource;
import com.verimed.backend.tracking.Interface.rest.resources.TrackingResource;
import com.verimed.backend.tracking.Interface.rest.transform.CreateTrackingCommandFromEntityAssembler;
import com.verimed.backend.tracking.Interface.rest.transform.TrackingResourceFromEntityAssembler;
import com.verimed.backend.tracking.domain.service.TrackingCommandService;
import com.verimed.backend.tracking.domain.service.TrackingQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/verimed/tracking", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrackingController {
    private final TrackingCommandService trackingCommandService;
    private final TrackingQueryService trackingQueryService;

    public TrackingController(TrackingCommandService trackingCommandService,
                              TrackingQueryService trackingQueryService) {
        this.trackingCommandService = trackingCommandService;
        this.trackingQueryService = trackingQueryService;
    }

    @PostMapping
    public ResponseEntity<TrackingResource> createTracking(@RequestBody CreateTrackingResource resource) {
        var command = CreateTrackingCommandFromEntityAssembler.toCommand(resource);
        var tracking = trackingCommandService.createTracking(command.factoryId(), command.batchId());
        var trackingResource = TrackingResourceFromEntityAssembler.toResourceFromEntity(tracking);
        return ResponseEntity.status(HttpStatus.CREATED).body(trackingResource);
    }

    @PutMapping("/{trackingId}/business")
    public ResponseEntity<TrackingResource> updateTrackingWithBusinessId(
            @PathVariable Long trackingId,
            @RequestParam Long businessId) {
        var tracking = trackingCommandService.updateTrackingWithBusinessId(trackingId, businessId);
        var trackingResource = TrackingResourceFromEntityAssembler.toResourceFromEntity(tracking);
        return ResponseEntity.ok(trackingResource);
    }

    @PutMapping("/{trackingId}/close")
    public ResponseEntity<TrackingResource> closeTracking(@PathVariable Long trackingId) {
        var tracking = trackingCommandService.closeTracking(trackingId);
        var trackingResource = TrackingResourceFromEntityAssembler.toResourceFromEntity(tracking);
        return ResponseEntity.ok(trackingResource);
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<TrackingResource> getTrackingById(@PathVariable Long trackingId) {
        var tracking = trackingQueryService.getTrackingById(trackingId)
                .orElseThrow(() -> new IllegalArgumentException("Tracking no encontrado"));
        var trackingResource = TrackingResourceFromEntityAssembler.toResourceFromEntity(tracking);
        return ResponseEntity.ok(trackingResource);
    }

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<List<TrackingResource>> getTrackingsByBatchId(@PathVariable Long batchId) {
        var trackings = trackingQueryService.getTrackingsByBatchId(batchId);
        var trackingResources = trackings.stream()
                .map(TrackingResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trackingResources);
    }

    @GetMapping("/factory/{factoryId}")
    public ResponseEntity<List<TrackingResource>> getTrackingsByFactoryId(@PathVariable Long factoryId) {
        var trackings = trackingQueryService.getTrackingsByFactoryId(factoryId);
        var trackingResources = trackings.stream()
                .map(TrackingResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trackingResources);
    }
}
