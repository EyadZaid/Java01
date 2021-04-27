package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.data.Movie;
import training.expires.logic.queries.IQuery;
import training.expires.logic.queries.QueryType;
import training.expires.logic.queries.UserQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {
    private UserQuery query;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        query = UserQuery.getInstance();
    }

    @Test
    void searchByImdbIdTest() {
        String idToSearch = "tt2948372";
        Movie movie = query.search(QueryType.IMDB_ID, idToSearch).get(0);
        System.out.println(movie);

        assertEquals(idToSearch, movie.getImdbID());
    }

    @Test
    void searchByTitleTest() {
        String title = "soul";
        List<Movie> movies = query.search(QueryType.TITLE, title);

        assertEquals(10, movies.size());

        String idToSearch = "tt2948372";
        Movie mov = query.search(QueryType.IMDB_ID, idToSearch).get(0);

        assertTrue(movies.contains(mov));

    }

}