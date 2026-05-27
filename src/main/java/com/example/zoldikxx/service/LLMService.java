package com.example.zoldikxx.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class LLMService {
    public LLMService(WebClient webClient) {
        this.webClient = webClient;
    }

    private final WebClient webClient;

    @Value("${openai.chat-url}")
    private String chatUrl;

    public String explainCode(String code, List<String> context) {

        String contextText = String.join("\n\n", context);

        String prompt = """
                You are a senior software engineer.

                Explain the following code clearly and simply.

                Use the project context if relevant.

                Context:
                %s

                Code:
                %s
                """.formatted(contextText, code);

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4.1-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                ),
                "temperature", 0.2
        );

        Map response = webClient.post()
                .uri(chatUrl)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<Map<String, Object>> choices =
                (List<Map<String, Object>>) response.get("choices");

        Map<String, Object> message =
                (Map<String, Object>) choices.get(0).get("message");

        return message.get("content").toString();
    }
}
