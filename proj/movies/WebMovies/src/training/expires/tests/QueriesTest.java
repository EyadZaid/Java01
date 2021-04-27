package training.expires.tests;

import org.junit.jupiter.api.Test;
import training.expires.data.Movie;
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

    /*
    @Test
    void searchByImdbIdTest() {
        String idToSearch1 = "tt2948372";
        Movie movie1 = query.search(QueryType.IMDB_ID, idToSearch1).get(0);
        assertEquals(idToSearch1, movie1.getImdbID());

        String idToSearch2 = "tt0220264";
        Movie movie2 = query.search(QueryType.IMDB_ID, idToSearch2).get(0);
        assertEquals(idToSearch2, movie2.getImdbID());

        String idToSearch3 = "tt0412142";
        Movie movie3 = query.search(QueryType.IMDB_ID, idToSearch3).get(0);
        assertEquals(idToSearch3, movie3.getImdbID());
    }

    @Test
    void searchByTitleTest() {
        String title = "soul";
        List<Movie> movies = query.search(QueryType.TITLE, title);

        assertEquals(10, movies.size());

        String idToSearch = "tt2948372";
        Movie mov = query.search(QueryType.IMDB_ID, idToSearch).get(0);

        assertTrue(movies.contains(mov));


        String title2 = "house";
        List<Movie> movies2 = query.search(QueryType.TITLE, title2);

        assertEquals(10, movies2.size());

        String idToSearch2 = "tt0412142";
        Movie mov2 = query.search(QueryType.IMDB_ID, idToSearch2).get(0);

        assertTrue(movies2.contains(mov2));


        String title3 = "Russia";
        List<Movie> movies3 = query.search(QueryType.TITLE, title3);

        assertEquals(10, movies3.size());

        String idToSearch3 = "tt0220264";
        Movie mov3 = query.search(QueryType.IMDB_ID, idToSearch3).get(0);

        assertEquals(idToSearch3, mov3.getImdbID());

    }
*/



}