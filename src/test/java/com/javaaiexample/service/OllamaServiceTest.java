package com.javaaiexample.service;

import com.javaaiexample.records.OllamaRecords.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OllamaServiceTest {
    private final OllamaService ollamaService = new OllamaService();

    @Test
    public void testGenerate() {
        var ollamaRequest = new OllamaRequest("gemma2", "Why is the sky blue?", false);
        OllamaResponse ollamaResponse = ollamaService.generate(ollamaRequest);
        String answer = ollamaResponse.response();
        System.out.println(answer);
        assertTrue(answer.toLowerCase().contains("scattering"));
    }
}