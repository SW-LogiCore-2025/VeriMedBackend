package com.verimed.backend.batch.Interface.rest.transform;


import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;

public class CreateProductCommandFromResourceAssembler {
    public static AddProductToBatchCommand toCommand(AddProductToBatchCommand resource) {
        return new AddProductToBatchCommand(
                resource.batchCode(),
                resource.productTypeId(),
                resource.quantity()
        );
    }
}
