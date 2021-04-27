package training.expires.logic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

public class RequestHttp implements Callable<String> {
    private String url;

    public RequestHttp(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        return getRequest(url);
    }

    public String getRequest(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (response == null ) {
            throw new IllegalStateException();
        }

        return response.body();
    }

}
