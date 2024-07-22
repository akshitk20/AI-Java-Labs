package com.javaaiexample.records;

import java.util.List;

public class GeminiRecords {

    public record Candidate(Content content) {
        public record Content(List<Part> parts, String role) {
            public record Part(String text) {}
        }
    }
}
