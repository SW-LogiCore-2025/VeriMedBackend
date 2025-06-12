package com.verimed.backend.batch.domain.service;

import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.queries.GetAllProductsByBatchCodeQuery;
import com.verimed.backend.batch.domain.model.queries.GetAllProductsQuery;
import com.verimed.backend.batch.domain.model.queries.GetProductBySerialNumberQuery;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductBySerialNumberQuery getProductByIdQuery);
    List<Product> handle(GetAllProductsByBatchCodeQuery getAllProductsByBatchCodeQuery);
    List<Product> handle(GetAllProductsQuery getAllProductsQuery);
}
