package com.javaaiexample.service;

import com.google.gson.Gson;
import com.javaaiexample.records.GeminiRecords;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiService {

    private static final String GEMINI_API_KEY = System.getenv("GEMINI_API_KEY");

    private final Gson gson = new Gson();

    public GeminiRecords.Candidate generateChat() {
        String payload = """
                {
                    "contents": [
                         {
                             "parts": [
                                 {
                                     "text": "Tell one line about AI."
                                 }
                             ]
                         }
                    ]
                }
                 """;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + GEMINI_API_KEY))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();
        try  {
            var client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            System.out.println(response.headers());
            return gson.fromJson(response.body(), GeminiRecords.Candidate.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
