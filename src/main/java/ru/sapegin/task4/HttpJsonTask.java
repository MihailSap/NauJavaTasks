package ru.sapegin.task4;

import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpJsonTask {

    public void run(){
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/ip"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String ip = extractIpFromResponse(response);
            System.out.printf("IP адрес, с которого был сделан запрос: %s%n", ip);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String extractIpFromResponse(HttpResponse<String> response){
        ObjectMapper objectMapper = new ObjectMapper();
        HttpBinResponse httpBinResponse = objectMapper.readValue(response.body(), HttpBinResponse.class);
        return httpBinResponse.origin();
    }
}
