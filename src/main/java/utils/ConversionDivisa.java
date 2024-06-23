package utils;

import com.google.gson.Gson;
import models.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionDivisa {
    public Moneda Conversion(String base_code, String target_code, double amount) {

        URI conversion = URI.create("https://v6.exchangerate-api.com/v6/3530afe36d7dfb3fbef9af13/pair/" + base_code + "/"
                + target_code + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(conversion)
                .build();

        HttpResponse<String> response;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ConvertirMoneda(new Gson().fromJson(response.body(), Moneda.class), amount);
    }

    public Moneda ConvertirMoneda(Moneda moneda, double amount) {
        double conversion = Double.valueOf(moneda.conversion_rate()) * amount;
        return new Moneda(String.valueOf(conversion));
    }
}
