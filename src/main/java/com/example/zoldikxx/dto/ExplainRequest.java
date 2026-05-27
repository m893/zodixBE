package com.example.zoldikxx.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExplainRequest {
    private String code;
    private List<String> context;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getContext() {
        return context;
    }

    public void setContext(List<String> context) {
        this.context = context;
    }
}
