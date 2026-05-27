package com.example.zoldikxx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class EmbeddingResponse {
    public EmbeddingResponse(List<Double> embeddings) {
        this.embeddings = embeddings;
    }

    private List<Double> embeddings;

    public List<Double> getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(List<Double> embeddings) {
        this.embeddings = embeddings;
    }
}
