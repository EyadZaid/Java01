package training.expires.logic.queries;

import training.expires.data.Movie;

public interface IParser {
    Movie parse(String input);
}
