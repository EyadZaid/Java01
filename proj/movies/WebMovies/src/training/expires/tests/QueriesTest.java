package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.data.Movie;
import training.expires.logic.queries.IQuery;
import training.expires.logic.queries.SearchByImdbId;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {
    private IQuery query;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @Test
    void searchByImdbIdTest() {
        query = new SearchByImdbId();
        String idToSearch = "tt2948372";
        Movie movie = query.search(idToSearch).get(0);
        System.out.println(movie);

        assertEquals(idToSearch, movie.getImdbID());
    }
}