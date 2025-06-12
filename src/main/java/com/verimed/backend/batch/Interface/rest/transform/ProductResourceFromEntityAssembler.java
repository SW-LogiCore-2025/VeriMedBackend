package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.domain.model.aggregates.Product;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product) {
        String formattedSerial = String.format("%05d", product.getSerialNumber());
        return new ProductResource(
            formattedSerial,
            product.getName(),
            product.getManufacturer()
        );
    }
}
