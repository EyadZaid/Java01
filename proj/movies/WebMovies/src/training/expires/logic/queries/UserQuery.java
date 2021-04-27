package training.expires.logic.queries;

import org.json.JSONArray;
import org.json.JSONObject;
import training.expires.data.Movie;
import training.expires.logic.RequestHttp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserQuery {
    private final static String API_KEY = "a4038bc6";
    private final static String URL_ID = "http://www.omdbapi.com/?i=";
    private final static String URL_TITLE = "http://www.omdbapi.com/?s=";
    private static UserQuery instance;
    private final ExecutorService pool;

    private UserQuery() {
        pool = Executors.newFixedThreadPool(2);
    }

    public static UserQuery getInstance() {
        if (instance == null) {
            instance = new UserQuery();
        }
        return instance;
    }


    public Movie searchById(String inputToSearch) {
        String url = URL_ID + inputToSearch + "&apikey=" + API_KEY;

        Future<String> requestResult = pool.submit(new RequestHttp(url));

        String requestValue = "";
        try {
            requestValue = requestResult.get();

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        ParserJson search = new ParserJson();
        return search.parseJsonToMovie(requestValue);
    }

    public List<Movie> searchByTitle(String inputToSearch) {
        String url = URL_TITLE + inputToSearch + "&apikey=" + API_KEY;

        Future<String> requestResult = pool.submit(new RequestHttp(url));

        String requestValue = "";
        try {
            requestValue = requestResult.get();

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        List<Movie> moviesList = new ArrayList<>();
        JSONObject obj = new JSONObject(requestValue);
        JSONArray arr = obj.getJSONArray("Search");

        for (int i = 0; i < arr.length(); i++) {
            var jsonObj = arr.getJSONObject(i);
            String imdb_id = jsonObj.getString("imdbID");
            moviesList.add(searchById(imdb_id));
        }
        return moviesList;
    }


    public void shutdown() {
        pool.shutdown();
    }


}
