package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.data.Movie;
import training.expires.logic.queries.IQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {
    private IQuery query;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    /*
    @Test
    void searchByImdbIdTest() {
        query = new SearchByImdbId();
        String idToSearch = "tt2948372";
        Movie movie = query.search(idToSearch).get(0);
        System.out.println(movie);

        assertEquals(idToSearch, movie.getImdbID());
    }

    @Test
    void searchByTitleTest() {
        query = new SearchByTitle();
        String title = "soul";
        List<Movie> movies = query.search(title);

        assertEquals(10, movies.size());

        query = new SearchByImdbId();
        String idToSearch = "tt2948372";
        Movie mov = query.search(idToSearch).get(0);

        assertTrue(movies.contains(mov));
    }

     */
}