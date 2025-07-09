package com.verimed.backend.batch.Interface.rest.transform;

import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.domain.model.aggregates.Product;

public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product product) {
        return new ProductResource(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getSerialNumber(),
                product.getBatch(),
                product.getProductType().getId(),
                product.getProductType().getName(),
                product.getProductType().getManufacturer(),
                product.getManufactureDate(),
                product.getExpirationDate(),
                product.getComposition()
        );
    }
}