package training.expires.logic;

import training.expires.data.Movie;

public interface QueryObserver {

    void onNewResult(Movie movie);
}
