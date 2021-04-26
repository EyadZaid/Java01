package training.expires.logic.queries;

import org.json.JSONArray;
import org.json.JSONObject;
import training.expires.data.Movie;
import training.expires.logic.RequestHttp;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle {
    private final static String API_KEY = "a4038bc6";
    private final RequestHttp requestHttp;

    public SearchByTitle() {
        requestHttp = new RequestHttp();
    }

    public List<Movie> search(String title) {
        String url = "http://www.omdbapi.com/?s=" + title + "&apikey=" + API_KEY;
        String jsonString = requestHttp.getRequest(url);
        List<String> imdbIDsList = new ArrayList<>();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("Search");
        for (int i = 0; i < arr.length(); i++) {
            String imdb_id = arr.getJSONObject(i).getString("imdbID");
            imdbIDsList.add(imdb_id);
        }

        return getMoviesByIDs(imdbIDsList);
    }


    private List<Movie> getMoviesByIDs(List<String> imdbIDsList) {
        SearchByImdbId searchById = new SearchByImdbId();
        List<Movie> movies = new ArrayList<>();
        for (var id : imdbIDsList) {
            movies.add(searchById.search(id));
        }
        return movies;
    }


}
