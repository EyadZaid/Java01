package training.expires;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
              }
        }


        getMovies(imdbIDsList);


        //System.out.println(response.body());
    }

    public static void getMovies(List<String> imdbIDsList) {
        List<Movie> moviesList = new ArrayList<>();

        for (var imdbID : imdbIDsList) {
            String apiKey = "a4038bc6";
            String urlSearchByID = "http://www.omdbapi.com/?i=" + imdbID + "&apikey=" + apiKey;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlSearchByID)).build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            if (response != null) {
                JSONObject obj = new JSONObject(response.body());

                String title = obj.getString("Title");
                String rated = obj.getString("Rated");
                String runtime = obj.getString("Runtime");
                String year = obj.getString("Year");

                String directors = obj.getString("Director");
                List<String> directorsList = Arrays.asList(directors.split("\\s*,\\s*"));

                String genres = obj.getString("Genre");
                List<String> genreList = Arrays.asList(genres.split("\\s*,\\s*"));

                Movie movie = new Movie(imdbID, title, rated, runtime, year, directorsList, genreList);
                moviesList.add(movie);
            }
        }
    }
}
