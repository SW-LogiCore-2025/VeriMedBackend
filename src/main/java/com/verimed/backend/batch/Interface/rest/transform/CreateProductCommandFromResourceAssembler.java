package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateProductResource;
import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommand(CreateProductResource command) {
        return new CreateProductCommand(
                command.name(),
                command.manufacturer()
        );
    }
}
