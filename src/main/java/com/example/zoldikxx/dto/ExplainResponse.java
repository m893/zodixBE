package com.example.zoldikxx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ExplainResponse {
    private String explanation;

    public ExplainResponse(String explanation) {
        this.explanation = explanation;
    }
}
