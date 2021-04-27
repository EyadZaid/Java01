package training.expires.logic.queries;

import org.json.JSONArray;
import org.json.JSONObject;
import training.expires.data.Movie;
import training.expires.logic.RequestHttp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

class SearchByTitle implements Callable<List<Movie>> {
    private final static String API_KEY = "a4038bc6";
    private final static String URL_TITLE = "http://www.omdbapi.com/?s=";
    private final static String URL_ID = "http://www.omdbapi.com/?i=";
    private final RequestHttp requestHttp;
    private final String titleToSearch;

    public SearchByTitle(String titleToSearch) {
        requestHttp = new RequestHttp();
        this.titleToSearch = titleToSearch;
    }

    @Override
    public List<Movie> call() throws Exception {
        return search();
    }

    private List<Movie> search() {
        String url = URL_TITLE + titleToSearch + "&apikey=" + API_KEY;
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
        SearchByImdbId searchById = new SearchByImdbId(titleToSearch);
        List<Movie> movies = new ArrayList<>();
        for (var id : imdbIDsList) {
            movies.add(searchByImdbId(id));
        }
        return movies;
    }

    private Movie searchByImdbId(String id) {
        String url = URL_ID + id + "&apikey=" + API_KEY;
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

        Movie movie = new Movie(id, title, rated, runtime, year, directorsList, genreList);
        return movie;
    }
}
