package com.verimed.backend.batch.Interface.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.Interface.rest.transform.CreateProductCommandFromResourceAssembler;
import com.verimed.backend.batch.Interface.rest.transform.ProductResourceFromEntityAssembler;
import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.domain.service.ProductQueryService;
import com.verimed.backend.blockchain.BlockchainService;
import com.verimed.backend.blockchain.PinataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/verimed/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;
    private final PinataService pinataService;
    private final ObjectMapper objectMapper;
    private final BlockchainService blockchainService;

    @Autowired
    public ProductController(ProductCommandService productCommandService,
                             ProductQueryService productQueryService,
                             PinataService pinataService,
                             ObjectMapper objectMapper,
                             BlockchainService blockchainService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
        this.pinataService = pinataService;
        this.objectMapper = objectMapper;
        this.blockchainService = blockchainService;
    }


    @PostMapping("/batch")
    public ResponseEntity<?> addProductToBatch(@RequestBody AddProductToBatchCommand resource) {
        var command = CreateProductCommandFromResourceAssembler.toCommand(resource);
        var products = productCommandService.handle(command);
        var productResources = products.stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        for (var productResource : productResources) {
            Map<String, Object> jsonMap = objectMapper.convertValue(productResource, Map.class);
            String cid = pinataService.uploadToPinata(jsonMap);

            String tokenURI = "https://gateway.pinata.cloud/ipfs/" + cid;
            // Ajusta el campo según tu ProductResource, por ejemplo getOwner()
            String recipient = "0x9aac2971E71499451600c9aB992a4308796D0907"; // Cambia esto si tu campo es diferente

            try {
                blockchainService.mintNFT(recipient, tokenURI);
                System.out.println("NFT minteado exitosamente para el CID: " + cid);
            } catch (Exception e) {
                System.err.println("Error al mintear NFT: " + e.getMessage());
            }
        }

        if (productResources.size() == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productResources.get(0));
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(productResources);
        }
    }

    @GetMapping
    public List<ProductResource> getAllProductsByBatch(@RequestParam String code) {
        return productQueryService.getProductsByBatch(code)
                .stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}