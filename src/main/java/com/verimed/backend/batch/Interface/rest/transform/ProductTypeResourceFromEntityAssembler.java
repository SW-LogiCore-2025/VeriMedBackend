package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.ProductTypeResource;
import com.verimed.backend.batch.domain.model.aggregates.ProductType;

public class ProductTypeResourceFromEntityAssembler {
    public static ProductTypeResource toResourceFromEntity(ProductType productType) {
        return new ProductTypeResource(
                productType.getId(),
                productType.getName(),
                productType.getManufacturer()
        );
    }
}
