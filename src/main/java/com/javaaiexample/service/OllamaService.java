package com.javaaiexample.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaaiexample.records.OllamaRecords.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OllamaService {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "http://localhost:11434";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public OllamaResponse generate(OllamaRequest ollamaRequest) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/api/generate"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        gson.toJson(ollamaRequest)))
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed with error code " + response.statusCode());
            }
            return gson.fromJson(response.body(), OllamaResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateStreaming(OllamaRequest ollamaRequest) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/api/generate"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ollamaRequest)))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    if (response.body().contains("false")) {
                        OllamaResponse output = gson.fromJson(response.body(), OllamaResponse.class);
                        System.out.print(output);
                    }
                });
    }

    public OllamaResponse generateVision(OllamaVisionRequest ollamaRequest) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "/api/generate"))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        gson.toJson(ollamaRequest)))
                .build();
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Failed with error code " + response.statusCode());
            }
            return gson.fromJson(response.body(), OllamaResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
