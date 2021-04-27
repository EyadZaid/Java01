package training.expires.logic.queries;

import java.util.ArrayList;
import java.util.List;
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







}
