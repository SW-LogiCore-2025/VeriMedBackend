package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateProductTypeResource;
import com.verimed.backend.batch.domain.model.commands.CreateProductTypeCommand;

public class CreateProductTypeCommandFromResourceAssembler {
    public static CreateProductTypeCommand toCommand(CreateProductTypeResource resource) {
        return new CreateProductTypeCommand(
                resource.name(),
                resource.manufacturer()
        );
    }
}
