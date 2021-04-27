package training.expires.logic.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserQuery {
    private final ExecutorService executor;
    private List<Future<?>> futuresList;


    public UserQuery() {
        executor = Executors.newFixedThreadPool(3);
        futuresList = new ArrayList<>();

    }




}
