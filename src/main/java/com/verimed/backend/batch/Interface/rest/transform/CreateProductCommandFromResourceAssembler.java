package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommand(CreateProductCommand command) {
        return new CreateProductCommand(
                command.name(),
                command.manufacturer(),
                command.batch()
        );
    }
}
