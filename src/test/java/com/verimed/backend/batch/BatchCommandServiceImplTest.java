package com.verimed.backend.batch;

import com.verimed.backend.batch.application.internal.commandservice.BatchCommandServiceImpl;
import com.verimed.backend.batch.domain.model.aggregates.Product;
import com.verimed.backend.batch.domain.model.commands.CreateBatchCommand;
import com.verimed.backend.batch.domain.model.entities.Batch;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.BatchRepository;
import com.verimed.backend.batch.infrastructure.persistence.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BatchCommandServiceImplTest {

    /*@Test
    void handle_shouldAssignBatchToProductsAndSave(){
        BatchRepository batchRepository = mock(BatchRepository.class);
        ProductRepository productRepository = mock(ProductRepository.class);

        UUID serial1 = UUID.randomUUID();
        UUID serial2 = UUID.randomUUID();
        Product product1 = new Product();
        product1.setSerialNumber(serial1);
        Product product2 = new Product();
        product2.setSerialNumber(serial2);

        List<UUID> serials = List.of(serial1, serial2);
        CreateBatchCommand command = mock(CreateBatchCommand.class);
        when(command.productSerialNumbers()).thenReturn(serials);

        when(productRepository.findAllBySerialNumberIn(serials)).thenReturn(List.of(product1, product2));
        when(batchRepository.save(any(Batch.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BatchCommandServiceImpl service = new BatchCommandServiceImpl(batchRepository, productRepository);

        Optional<Batch> result = service.handle(command);

        assertTrue(result.isPresent());
        verify(productRepository).saveAll(List.of(product1, product2));
        verify(batchRepository).save(any(Batch.class));
    }*/
}
