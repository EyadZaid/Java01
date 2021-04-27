package training.expires.logic.queries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import training.expires.data.Movie;
import training.expires.logic.RequestHttp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Query {
    private final static String URL_ID = "http://www.omdbapi.com/?i=";
    private final static String URL_TITLE = "http://www.omdbapi.com/?s=";
    private final static String API_KEY = "a4038bc6";
    private final static int NUM_THREADS = 10;
    private static Query instance;
    private final ExecutorService pool;
    private final IParser parser;

    private Query() {
        pool = Executors.newFixedThreadPool(NUM_THREADS);
        parser = new ParserJson();
    }

    public static Query getInstance() {
        if (instance == null) {
            instance = new Query();
        }
        return instance;
    }


    public Movie searchById(String inputToSearch) {
        inputToSearch = inputToSearch.trim().replace(' ', '+');
        String url = URL_ID + inputToSearch + "&apikey=" + API_KEY;

        Future<String> requestResult = pool.submit(new RequestHttp(url));

        String requestValue = "";
        try {
            requestValue = requestResult.get();

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        if (!isJSONValid(requestValue)) {
            return null;
        }

        return parser.parse(requestValue);
    }

    public List<Movie> searchByTitle(String inputToSearch) {
        inputToSearch = inputToSearch.trim().replace(' ', '+');
        String url = URL_TITLE + inputToSearch + "&apikey=" + API_KEY;

        Future<String> requestResult = pool.submit(new RequestHttp(url));

        String requestValue = "";
        try {
            requestValue = requestResult.get();

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        if (!isJSONValid(requestValue)) {
            return null;
        }

        JSONObject obj = new JSONObject(requestValue);
        if (obj.has("Response") && !obj.getBoolean("Response")) {
            return null;
        }
        return getMoviesByTitle(obj);
    }

    public void shutdown() {
        pool.shutdown();
    }

    private List<Movie> getMoviesByTitle(JSONObject jsonObj) {
        List<Movie> moviesList = new ArrayList<>();
        JSONArray arr = jsonObj.getJSONArray("Search");

        for (int i = 0; i < arr.length(); i++) {
            String imdb_id = arr.getJSONObject(i).getString("imdbID");
            moviesList.add(searchById(imdb_id));
        }
        return moviesList;
    }

    private boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
