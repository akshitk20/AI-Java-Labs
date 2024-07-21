package com.javaaiexample.service;

import com.javaaiexample.records.OllamaRecords.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OllamaServiceTest {
    private final OllamaService ollamaService = new OllamaService();

    @Test
    public void testGenerate() {
        var ollamaRequest = new OllamaTextRequest("gemma2", "Why is the sky blue?", false);
        OllamaResponse ollamaResponse = ollamaService.generate(ollamaRequest);
        String answer = ollamaResponse.response();
        System.out.println(answer);
        assertTrue(answer.toLowerCase().contains("scattering"));
    }

    @Test
    public void streaming_generate_request() {
        var request = new OllamaTextRequest("gemma2", "Why is the sky blue?", true);
        System.out.println("starting test");
        ollamaService.generateStreaming(request);
    }

    @Test
    void test_vision_generate() {
        var request = new OllamaVisionRequest("moondream",
                """
                Generate a text description of this image
                suitable for accessibility in HTML.
                """,
                false,
                List.of("src/main/resources/cats_playing_cards.png"));
        System.out.println("starting test");
        OllamaResponse ollamaResponse = ollamaService.generate(request);
        assertNotNull(ollamaResponse);
        System.out.println(ollamaResponse.response());
    }

}