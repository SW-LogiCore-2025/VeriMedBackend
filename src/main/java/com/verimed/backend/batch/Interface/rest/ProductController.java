package com.verimed.backend.batch.Interface.rest;

import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.Interface.rest.transform.CreateProductCommandFromResourceAssembler;
import com.verimed.backend.batch.Interface.rest.transform.ProductResourceFromEntityAssembler;

import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.domain.service.ProductQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/verimed/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @PostMapping("/batch")
    public ResponseEntity<Void> addProductToBatch(@RequestBody AddProductToBatchCommand resource) {
        var command = CreateProductCommandFromResourceAssembler.toCommand(resource);
        productCommandService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<ProductResource> getAllProductsByBatch(@RequestParam String code) {
        return productQueryService.getProductsByBatch(code)
                .stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}