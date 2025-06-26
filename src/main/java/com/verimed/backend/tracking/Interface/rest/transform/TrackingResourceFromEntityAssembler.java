package com.verimed.backend.tracking.Interface.rest.transform;

import com.verimed.backend.tracking.Interface.rest.resources.TrackingResource;
import com.verimed.backend.tracking.domain.model.entities.Tracking;

public class TrackingResourceFromEntityAssembler {
    public static TrackingResource toResourceFromEntity(Tracking tracking) {
        return new TrackingResource(
                tracking.getId(),
                tracking.getFactoryId(),
                tracking.getBusinessIds(),
                tracking.getIsClosed()
        );
    }
}
