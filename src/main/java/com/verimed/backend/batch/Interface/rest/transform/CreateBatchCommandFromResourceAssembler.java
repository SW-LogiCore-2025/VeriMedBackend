package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.CreateBatchResource;
import com.verimed.backend.batch.Interface.rest.resources.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;

import java.util.Collections;
import java.util.List;

public class CreateBatchCommandFromResourceAssembler {
    public static CreateBatchCommand toCommand(CreateBatchResource resource) {
        // Aquí deberías mapear los productos a comandos si es necesario
        List<AddProductToBatchCommand> products = resource.products() != null ? resource.products() : Collections.emptyList();
        // Ejemplo: podrías transformar los productos a comandos si tu CreateBatchCommand lo requiere
        return new CreateBatchCommand(
                resource.hash(),
                resource.certificateUrl()
        );
    }
}
