package com.javaaiexample.records;

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
}
