package com.verimed.backend.batch.domain.service;

public interface QrCodeService {
    String generateQrCodeBase64(String text);
    String decodeQrCodeBase64(String qrBase64) throws Exception;
}