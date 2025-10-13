package com.scalar.ecom.commons;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private RestTemplate restTemplate;
    public AuthCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void validateToken(String tokenValue){
        HttpHeaders headers = new HttpHeaders();
        headers.set("tokenValue", tokenValue);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    "http://UserAuthService/auth/validate",
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            // Check if response is not 2xx
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException(response.getBody());
            }

        } catch (HttpClientErrorException e) {
            // Handle 400 Bad Request or other client errors
            throw new RuntimeException(e.getResponseBodyAsString());
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }
}
