package training.expires.logic.queries;

import training.expires.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class UserQuery {
    private static UserQuery instance;

    private UserQuery() {

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

        return new ArrayList<>();
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
