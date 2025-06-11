package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.BatchResource;
import com.verimed.backend.batch.domain.model.entities.Batch;

public class BatchResourceFromEntityAssembler {
    public static BatchResource toResourceFromEntity(Batch batch) {
        return new BatchResource(
            batch.getCode(),
            batch.getHash(),
            batch.getCreatedAt(),
            batch.getProducts(),
            batch.getCertificateUrl()
        );
    }
}
