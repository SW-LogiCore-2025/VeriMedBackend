package com.verimed.backend.blockchain;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;

public class PinataService {
    private static final String PINATA_URL = "https://api.pinata.cloud/pinning/pinJSONToIPFS";
    private static final String JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJmNGFlNTI5MS01MGRlLTRjNGMtYWZjMy0wMzlmMjljMzZmN2EiLCJlbWFpbCI6ImpjYWJyZXJhY2FtaXphbkBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicGluX3BvbGljeSI6eyJyZWdpb25zIjpbeyJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MSwiaWQiOiJGUkExIn0seyJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MSwiaWQiOiJOWUMxIn1dLCJ2ZXJzaW9uIjoxfSwibWZhX2VuYWJsZWQiOmZhbHNlLCJzdGF0dXMiOiJBQ1RJVkUifSwiYXV0aGVudGljYXRpb25UeXBlIjoic2NvcGVkS2V5Iiwic2NvcGVkS2V5S2V5IjoiZjM1YjJmYjdkZTNjNDU5ZWVlZDgiLCJzY29wZWRLZXlTZWNyZXQiOiJkY2RlM2RlM2U2MTRmNzNhYTVjOTRmOGJhYjdiNDQ3NDM1MjllNGQ0ZTJmY2MwZmMyMzM3YmUwYjQ1YjM4ZWVhIiwiZXhwIjoxNzgxNDAxMzk5fQ.fQHHKhxIPGGqsktTwXyjKenOhtJFR0eLLCz9X265O0o";

    public String uploadToPinata(Map<String, Object> jsonData) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + JWT);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonData, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(PINATA_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().get("IpfsHash").toString(); // Devuelve el CID
        } else {
            throw new RuntimeException("Error al subir a Pinata: " + response.getStatusCode());
        }
    }
}