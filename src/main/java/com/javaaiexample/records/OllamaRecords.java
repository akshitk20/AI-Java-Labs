package com.javaaiexample.records;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class OllamaRecords {
    public record OllamaRequest(
            String model,
            String prompt,
            boolean stream) {
    }

    public record OllamaResponse(
            String model,
            String created_at, // Shouldn't this be camel case?
            String response,
            boolean done) {
    }

    public record OllamaVisionRequest(
            String model,
            String prompt,
            boolean stream,
            List<String> images) {
        public OllamaVisionRequest {
            images = images.stream()
                    .map(this::encodeImage)
                    .collect(Collectors.toList());
        }

        private String encodeImage(String path) {
            try {
                byte[] imageBytes = Files.readAllBytes(Paths.get(path));
                return Base64.getEncoder().encodeToString(imageBytes);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
