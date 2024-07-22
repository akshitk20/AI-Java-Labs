package com.javaaiexample.service;

import com.javaaiexample.records.GeminiRecords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeminiServiceTest {

    private final GeminiService geminiService = new GeminiService();

    @Test
    void testGenerateTest() {
        GeminiRecords.Candidate candidate = geminiService.generateChat();
        System.out.println(candidate.content());
    }
}