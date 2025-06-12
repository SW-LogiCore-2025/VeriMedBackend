package com.verimed.backend.batch.Interface.rest;

import com.verimed.backend.batch.Interface.rest.resources.CreateProductResource;
import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.Interface.rest.transform.CreateProductCommandFromResourceAssembler;
import com.verimed.backend.batch.Interface.rest.transform.ProductResourceFromEntityAssembler;
import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.commands.DeleteProductCommand;
import com.verimed.backend.batch.domain.model.queries.GetAllProductsQuery;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.domain.service.ProductQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;
    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResource>> getAllProducts() {
        List<Product> productSource = productQueryService.handle(new GetAllProductsQuery());
        var productResources = productSource
                .stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(productResources);
    }

    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource createProductResource) {
        Optional<Product> productSource = productCommandService.handle(CreateProductCommandFromResourceAssembler.toCommand(createProductResource));
        return productSource.map(s -> new ResponseEntity<>(ProductResourceFromEntityAssembler
                        .toResourceFromEntity(s), HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productCommandService.handle(new DeleteProductCommand(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@GetMapping("/batch/{batchCode}")
    public ResponseEntity<List<ProductResource>> getAllProductsByBatchCode(@PathVariable UUID batchCode) {
        List<Product> productSource = productQueryService.handle(new GetAllProductsByBatchCodeQuery());
        var productResources = productSource
                .stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(productResources);
    }*/
}
