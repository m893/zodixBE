package com.example.zoldikxx.controller;

import com.example.zoldikxx.dto.EmbeddingRequest;
import com.example.zoldikxx.dto.EmbeddingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.zoldikxx.service.EmbeddingService;

import java.util.List;


@RestController
@RequestMapping("/api/embed")
public class EmbeddingController {

    private final EmbeddingService embeddingService;
    @Autowired
    public EmbeddingController(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @PostMapping
    public EmbeddingResponse embed(@RequestBody EmbeddingRequest request) {

        System.out.println("Request Body: "+request.getTexts());
        List<Double> embeddings =
                embeddingService.generateEmbeddings(request.getTexts());

        return new EmbeddingResponse(embeddings);
    }
}
