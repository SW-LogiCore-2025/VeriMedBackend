package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.BatchResource;
import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.entities.Batch;

import java.util.List;

public class BatchResourceFromEntityAssembler {
    public static BatchResource toResourceFromEntity(Batch batch, List<Product> products) {
        return new BatchResource(
            batch.getCode(),
            batch.getHash(),
            batch.getCreatedAt(),
            products,
            batch.getCertificateUrl()
        );
    }
}
