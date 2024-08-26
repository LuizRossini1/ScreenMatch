package br.com.alura.screenmatch.service;
import java.net.http.*;
import java.net.*;
import java.io.*;

public class ConsumoAPI {
        public String obterDados(String endereco) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = null;

            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String json = response.body();
            return json;
        }
    }
}