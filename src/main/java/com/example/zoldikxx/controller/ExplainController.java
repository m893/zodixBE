package com.example.zoldikxx.controller;


import com.example.zoldikxx.dto.ExplainRequest;
import com.example.zoldikxx.dto.ExplainResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.zoldikxx.service.LLMService;

@RestController
@RequestMapping("/api/explain")
public class ExplainController {

    public ExplainController(LLMService llmService) {
        this.llmService = llmService;
    }

    private final LLMService llmService;

    @PostMapping
    public ExplainResponse explain(@RequestBody ExplainRequest request) {

        String result = llmService.explainCode(
                request.getCode(),
                request.getContext()
        );

        return new ExplainResponse(result);
    }
}
