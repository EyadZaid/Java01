package training.expires.logic.queries;

import org.json.JSONObject;
import training.expires.data.Movie;
import training.expires.logic.RequestHttp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchByImdbId implements IQuery{
    private final static String API_KEY = "a4038bc6";
    private final static String URL_ID = "http://www.omdbapi.com/?i=";
    private final RequestHttp requestHttp;

    public SearchByImdbId() {
        requestHttp = new RequestHttp();
    }

    @Override
    public List<Movie> search(String imdbID) {
        String url = URL_ID + imdbID + "&apikey=" + API_KEY;
        String jsonString = requestHttp.getRequest(url);

        JSONObject obj = new JSONObject(jsonString);

        String title = obj.getString("Title");
        String rated = obj.getString("Rated");
        String runtime = obj.getString("Runtime");
        String year = obj.getString("Year");

        String directors = obj.getString("Director");
        List<String> directorsList = Arrays.asList(directors.split("\\s*,\\s*"));

        String genres = obj.getString("Genre");
        List<String> genreList = Arrays.asList(genres.split("\\s*,\\s*"));

        Movie movie = new Movie(imdbID, title, rated, runtime, year, directorsList, genreList);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        return movies;
    }
}
