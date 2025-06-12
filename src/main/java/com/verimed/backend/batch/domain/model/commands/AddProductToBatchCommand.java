package com.verimed.backend.batch.domain.model.commands;

public record AddProductToBatchCommand (
        String batchCode,
        Long productTypeId,
        int quantity
){
}
