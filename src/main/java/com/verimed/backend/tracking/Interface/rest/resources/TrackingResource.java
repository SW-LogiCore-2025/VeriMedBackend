package com.verimed.backend.tracking.Interface.rest.resources;

import java.util.List;

public record TrackingResource(
        Long batchId,
        Long factoryId,
        List<Long> businessIds,
        Boolean isClosed
) {
}
