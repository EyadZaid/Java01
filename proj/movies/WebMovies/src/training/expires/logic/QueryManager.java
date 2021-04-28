package training.expires.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueryManager {
    private final static String URL_ID = "http://www.omdbapi.com/?i=";
    private final static String URL_TITLE = "http://www.omdbapi.com/?s=";
    private final static String API_KEY = "a4038bc6";
    private final static int NUM_THREADS = 4;
    private final ExecutorService pool;
    private final List<Future<String>> futureList;
    private final QueryObserver observer;
    private final ParserJson parser;

    public QueryManager(QueryObserver observer) {
        pool = Executors.newFixedThreadPool(NUM_THREADS);
        parser = new ParserJson();
        futureList = new ArrayList<>();
        this.observer = observer;
    }

    public void searchByTitle(String inputToSearch) {
        inputToSearch = inputToSearch.trim().replace(' ', '+');
        String url = URL_TITLE + inputToSearch + "&apikey=" + API_KEY;

        Future<String> future = pool.submit(new APIServer(url));

        String requestValue = "";
        try {
            requestValue = future.get();

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        if (!isJSONValid(requestValue)) {
            return;
        }

        JSONObject obj = new JSONObject(requestValue);
        if (obj.has("Response") && !obj.getBoolean("Response")) {
            return;
        }
        getMoviesByTitle(obj);
    }

    public void shutdown() {
        pool.shutdown();
    }

    private void getMoviesByTitle(JSONObject jsonObj) {
        JSONArray arr = jsonObj.getJSONArray("Search");

        for (int i = 0; i < arr.length(); i++) {
            String imdb_id = arr.getJSONObject(i).getString("imdbID");
            searchById(imdb_id);
        }
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

    public void searchById(String inputToSearch) {
        inputToSearch = inputToSearch.trim().replace(' ', '+');
        String url = URL_ID + inputToSearch + "&apikey=" + API_KEY;

        Future<String> requestResult = pool.submit(new APIServer(url));

        futureList.add(requestResult);

        //getResults();
    }

    public void getResults() {
        Iterator<Future<String>> iterator = futureList.iterator();
        while (iterator.hasNext()){
            var future = iterator.next();
            if (future.isDone()) {

                String requestValue = "";
                try {
                    requestValue = future.get();

                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }

                if (!isJSONValid(requestValue)) {
                    iterator.remove();
                    continue;
                }

                var movie= parser.parse(requestValue);

                if (movie != null){
                    observer.onNewResult(movie);
                }
                iterator.remove();
            }
        }

    }
}
