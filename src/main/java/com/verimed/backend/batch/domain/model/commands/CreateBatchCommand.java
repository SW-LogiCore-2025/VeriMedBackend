package com.verimed.backend.batch.domain.model.commands;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public record CreateBatchCommand(
        String nameBatch,
        String certificateUrl
) {
    public CreateBatchCommand {
        if (nameBatch == null || nameBatch.isEmpty()) {
            throw new IllegalArgumentException("nameBatch cannot be null or empty");
        }
    }

    public String hash() {
        return generateHashFromName(nameBatch);
    }

    private static String generateHashFromName(String name) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(name.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}