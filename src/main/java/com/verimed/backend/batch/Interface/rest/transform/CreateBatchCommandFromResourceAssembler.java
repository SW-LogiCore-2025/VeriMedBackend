package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateBatchResource;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

import java.util.List;
import java.util.UUID;

public class CreateBatchCommandFromResourceAssembler {
    public static CreateBatchCommand toCommand(CreateBatchResource command) {
        List<UUID> serialNumbers = command.products()
                .stream()
                .map(CreateProductCommand::serialNumber)
                .toList();
        return new CreateBatchCommand(
                command.hash(),
                serialNumbers,
                command.certificateUrl()
        );
    }
}
