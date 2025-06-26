package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.BatchResource;
import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.entities.Batch;

import java.util.List;

public class BatchResourceFromEntityAssembler {
    public static BatchResource toResourceFromEntity(Batch batch, List<Product> products) {
        List<ProductResource> productResources = products.stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return new BatchResource(
                batch.getCode(),
                batch.getName(),
                batch.getCreatedAt(),
                productResources,
                batch.getCertificateUrl()
        );
    }
}
