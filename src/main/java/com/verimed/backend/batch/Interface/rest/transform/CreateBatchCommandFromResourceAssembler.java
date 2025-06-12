package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateBatchResource;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.commands.CreateProductCommand;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CreateBatchCommandFromResourceAssembler {
    public static CreateBatchCommand toCommand(CreateBatchResource command) {
        /*List<UUID> serialNumbers = command.products()
                .stream()
                .map(CreateProductCommand::serialNumber)
                .toList();*/
        List<Long> serialNumber = command.products() != null
                ? command.products().stream()
                .map(p -> (long) (Math.random() * 1_000_000_000L))
                .toList()
                : Collections.emptyList();
        return new CreateBatchCommand(
                command.hash(),
                serialNumber,
                command.certificateUrl()
        );
    }
}
