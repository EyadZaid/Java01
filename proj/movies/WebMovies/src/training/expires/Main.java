package training.expires;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    /// http://www.omdbapi.com/?s=soul&apikey=a4038bc6
    /// http://www.omdbapi.com/?i=tt2948372&apikey=a4038bc6


    public static void main(String[] args) {

        String apiKey = "a4038bc6";
        String title = "soul";
        String urlSearchByTitle = "http://www.omdbapi.com/?s=" + title + "&apikey=" + apiKey;

        String imdbID = "tt2948372";
        String urlSearchByID = "http://www.omdbapi.com/?i=" + imdbID + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlSearchByTitle)).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


        List<String> imdbIDsList = new ArrayList<>();

        if (request != null) {
            JSONObject obj = new JSONObject(response.body());
            JSONArray arr = obj.getJSONArray("Search");
            for (int i = 0; i < arr.length(); i++) {
                String imdb_id = arr.getJSONObject(i).getString("imdbID");
                imdbIDsList.add(imdb_id);
                System.out.println(imdb_id);
            }

        }










        //System.out.println(response.body());
    }
}
