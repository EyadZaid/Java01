package training.expires.logic.queries;

import training.expires.data.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserQuery {
    private static UserQuery instance;
    private final ExecutorService executor;
    private List<Future<?>> futuresList;


    private UserQuery() {
        executor = Executors.newFixedThreadPool(3);
        futuresList = new ArrayList<>();

    }

    public static UserQuery getInstance() {
        if (instance == null) {
            instance = new UserQuery();
        }
        return instance;
    }


    public List<Movie> search(QueryType queryType, String inputToSearch) {
        switch (queryType) {
            case IMDB_ID -> { return searchById(inputToSearch); }

            case TITLE -> { return searchByTitle(inputToSearch); }
        }

        return null;
    }

    private List<Movie> searchById(String inputToSearch) {
        SearchByImdbId searchByImdbId = new SearchByImdbId(inputToSearch);
        Thread thread = new Thread(searchByImdbId);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return searchByImdbId.getResult();
    }


    private List<Movie> searchByTitle(String inputToSearch) {
        SearchByTitle searchByTitle = new SearchByTitle(inputToSearch);
        Thread thread = new Thread(searchByTitle);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return searchByTitle.getResult();
    }





}
