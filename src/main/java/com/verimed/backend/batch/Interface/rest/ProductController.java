package com.verimed.backend.batch.Interface.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verimed.backend.batch.Interface.rest.resources.ProductResource;
import com.verimed.backend.batch.Interface.rest.transform.CreateProductCommandFromResourceAssembler;
import com.verimed.backend.batch.Interface.rest.transform.ProductResourceFromEntityAssembler;
import com.verimed.backend.batch.domain.model.commands.AddProductToBatchCommand;
import com.verimed.backend.batch.domain.service.ProductCommandService;
import com.verimed.backend.batch.domain.service.ProductQueryService;
import com.verimed.backend.batch.domain.service.QrCodeService;
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
    private final QrCodeService qrCodeService;
    //private final PinataService pinataService;
    //private final ObjectMapper objectMapper;
    //private final BlockchainService blockchainService;

    @Autowired
    public ProductController(ProductCommandService productCommandService,
                             ProductQueryService productQueryService,
                             PinataService pinataService,
                             ObjectMapper objectMapper,
                             BlockchainService blockchainService,
                             QrCodeService qrCodeService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
        this.qrCodeService = qrCodeService;
        //this.pinataService = pinataService;
        //this.objectMapper = objectMapper;
        //this.blockchainService = blockchainService;
    }


    @PostMapping("/batch")
    public ResponseEntity<?> addProductToBatch(@RequestBody AddProductToBatchCommand resource) {
        var command = CreateProductCommandFromResourceAssembler.toCommand(resource);
        var products = productCommandService.handle(command);
        var productResources = products.stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();


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

    @GetMapping("/{id}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long id) {
        var productOpt = productQueryService.getProductById(id);
        if (productOpt.isPresent()) {
            var resource = ProductResourceFromEntityAssembler.toResourceFromEntity(productOpt.get());
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-type")
    public List<ProductResource> getProductsByProductType(@RequestParam Long productTypeId) {
        return productQueryService.getProductsByProductType(productTypeId)
                .stream()
                .map(ProductResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }

    @GetMapping("/by-serial/{serialNumber}")
    public ResponseEntity<ProductResource> getProductBySerialNumber(@PathVariable String serialNumber) {
        var productOpt = productQueryService.getProductBySerialNumber(serialNumber);
        if (productOpt.isPresent()) {
            var resource = ProductResourceFromEntityAssembler.toResourceFromEntity(productOpt.get());
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/by-qr")
    public ResponseEntity<ProductResource> getProductByQr(@RequestBody String qrBase64) {
        try {
            // Decodifica el QR y extrae el serial
            String qrData = qrCodeService.decodeQrCodeBase64(qrBase64);
            // Extrae el serial del QR (asumiendo que la URL termina con el serial)
            String serialNumber = qrData.substring(qrData.lastIndexOf("/") + 1);
            var productOpt = productQueryService.getProductBySerialNumber(serialNumber);
            if (productOpt.isPresent()) {
                var resource = ProductResourceFromEntityAssembler.toResourceFromEntity(productOpt.get());
                return ResponseEntity.ok(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}