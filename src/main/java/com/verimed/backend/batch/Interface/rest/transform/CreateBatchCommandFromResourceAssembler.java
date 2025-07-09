package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateBatchResource;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;

public class CreateBatchCommandFromResourceAssembler {
    public static CreateBatchCommand toCommand(CreateBatchResource resource) {
        return new CreateBatchCommand(
                resource.nameBatch(),
                resource.certificateUrl(),
                resource.userId() // <-- Agregado aquí
        );
    }
}