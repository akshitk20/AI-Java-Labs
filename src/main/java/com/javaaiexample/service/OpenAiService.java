package com.javaaiexample.service;

import com.google.gson.Gson;
import com.javaaiexample.records.OpenAiRecords;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenAiService {
    private static final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY");
    private static final String MODELS_URL = "https://api.openai.com/v1/models";
    private final Gson gson = new Gson();

    public OpenAiRecords.ModelList listModels() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MODELS_URL))
                .header("Authorization", "Bearer %s".formatted(OPENAI_API_KEY))
                .header("Accept", "application/json")
                .build();
        try  {
            var client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            System.out.println(response.headers());
            return gson.fromJson(response.body(), OpenAiRecords.ModelList.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
