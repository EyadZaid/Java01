package training.expires.logic;

import training.expires.data.Movie;
import training.expires.logic.outputs.IOutput;

public class QueryResults implements QueryObserver{
    private IOutput output;

    public QueryResults(IOutput output) {
        this.output = output;
    }

    @Override
    public void onNewResult(Movie movie) {
        output.write(movie.toString());
    }
}
