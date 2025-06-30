package com.verimed.backend.tracking.Interface.rest.transform;

import com.verimed.backend.tracking.Interface.rest.resources.CreateTrackingResource;
import com.verimed.backend.tracking.domain.model.commands.CreateTrackingCommand;

import java.util.List;

public class CreateTrackingCommandFromEntityAssembler {
    public static CreateTrackingCommand toCommand(CreateTrackingResource resource) {
        return new CreateTrackingCommand(
                resource.batchId(),
                resource.factoryId()
        );
    }
}
