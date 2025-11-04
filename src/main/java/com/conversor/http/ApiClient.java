package com.conversor.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String URL = "https://v6.exchangerate-api.com/v6/29eec4cfc2ba706734af4e4c/pair/";
    public final HttpClient client;

    public ApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String getJson(String baseCode, String targetCode, double amount) {
        try {
            String url = createUrl(baseCode, targetCode, amount);

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("OUVE UM ERRO NA REQUISIÇÃO");
        }
    }

    private String createUrl(String baseCode, String targetCode, double amount) {
        return URL + baseCode + "/" + targetCode + "/" + amount;
    }
}
