package com.sentiment.tracker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SentimentAnalysisService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${sentiment.api.url}")
    private String sentimentApiUrl;

    @Value("${sentiment.api.ua}")
    private String sentimentApiUa;

    @Value("${sentiment.api.key}")
    private String sentimentApiKey;

    @Value("${sentiment.api.host}")
    private String sentimentApiHost;

    public String analyseSentiment(String text){
        // Define the URL
        String url = sentimentApiUrl;

        // Create the request body dynamically based on the input text
        String requestBody = "[{\"language\":\"en\",\"text\":\"" + text + "\"}]";

        // Set up the headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-ua", sentimentApiUa);
        headers.set("x-rapidapi-key", sentimentApiKey);
        headers.set("x-rapidapi-host", sentimentApiHost);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity with the request body and headers
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        try {
            String prediction = new ObjectMapper().readTree(response.getBody()).get(0).get("predictions").get(0).get("prediction").asText();
            return prediction;
        } catch (Exception e) {
            e.getMessage();
            return "Unknown";
        }
     
    }
}
