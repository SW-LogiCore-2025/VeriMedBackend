package com.verimed.backend.batch.Interface.rest;

import com.verimed.backend.batch.domain.model.aggregates.ProductType;
import com.verimed.backend.batch.domain.model.commands.CreateProductTypeCommand;
import com.verimed.backend.batch.domain.service.ProductTypeCommandService;
import com.verimed.backend.batch.domain.service.ProductTypeQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/verimed/product-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductTypeController {
    private final ProductTypeCommandService productTypeCommandService;
    private final ProductTypeQueryService productTypeQueryService;

    public ProductTypeController(ProductTypeCommandService productTypeCommandService, ProductTypeQueryService productTypeQueryService) {
        this.productTypeCommandService = productTypeCommandService;
        this.productTypeQueryService = productTypeQueryService;
    }

    @PostMapping
    public ResponseEntity<Void> createProductType(@RequestBody CreateProductTypeCommand command) {
        productTypeCommandService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeQueryService.getAllProductTypes();
    }
}
