package com.example.zoldikxx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;


@Service
public class EmbeddingService {



    private final WebClient webClient;

    @Value("${openai.embedding-url}")
    private String embeddingUrl;
    public EmbeddingService(WebClient webClient, @Value("${openai.embedding-url}") String embeddingUrl) {
        this.webClient = webClient;
        this.embeddingUrl = embeddingUrl;
    }

    public List<Double> generateEmbeddings(List<String> texts) {


        Map<String, Object> requestBody = Map.of(
                "model", "nomic-embed-text",
                "prompt", texts.get(0)
        );

        Map response = webClient.post()
                .uri("http://localhost:11434/api/embeddings")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        System.out.println(response.get("embedding"));
            List<Double> result = (List<Double>) response.get("embedding");
        return  result ;

    }
}
