package com.example.zoldikxx.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmbeddingRequest {
    private List<String> texts;

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }
}
