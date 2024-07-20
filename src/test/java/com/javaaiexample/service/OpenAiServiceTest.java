package com.javaaiexample.service;

import com.javaaiexample.records.OpenAiRecords;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiServiceTest {
    private final OpenAiService openAiService = new OpenAiService();

    @Test
    void listModels() {
        List<String> models = openAiService.listModels().data().stream()
                .map(OpenAiRecords.ModelList.Model::id)
                .sorted()
                .toList();

        models.forEach(System.out::println);
        assertTrue(new HashSet<>(models).containsAll(
                List.of("dall-e-3", "gpt-3.5-turbo", "gpt-4o-mini",
                        "tts-1", "whisper-1")));
    }
}