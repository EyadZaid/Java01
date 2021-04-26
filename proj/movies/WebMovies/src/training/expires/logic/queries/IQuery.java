package training.expires.logic.queries;

import training.expires.data.Movie;

import java.util.List;

public interface IQuery {
    List<Movie> search(String input);
}
