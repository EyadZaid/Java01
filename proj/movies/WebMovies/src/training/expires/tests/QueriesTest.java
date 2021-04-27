package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Movie;
import training.expires.logic.queries.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueriesTest {
    private Query query;

    @BeforeEach
    void setUp() {
        query = Query.getInstance();
    }

    @Test
    void searchThreeMoviesByImdbIdTest() {
        String idToSearch1 = "tt2948372";
        Movie movie1 = query.searchById(idToSearch1);
        assertEquals(idToSearch1, movie1.getImdbID());

        String idToSearch2 = "tt0220264";
        Movie movie2 = query.searchById(idToSearch2);
        assertEquals(idToSearch2, movie2.getImdbID());

        String idToSearch3 = "tt0412142";
        Movie movie3 = query.searchById(idToSearch3);
        assertEquals(idToSearch3, movie3.getImdbID());
    }

    @Test
    void searchThreeMoviesByTitleTest() {
        String title = "soul";
        List<Movie> movies = query.searchByTitle(title);

        assertEquals(10, movies.size());

        String idToSearch = "tt2948372";
        Movie mov = query.searchById(idToSearch);

        assertTrue(movies.contains(mov));


        String title2 = "house";
        List<Movie> movies2 = query.searchByTitle(title2);

        assertEquals(10, movies2.size());

        String idToSearch2 = "tt0412142";
        Movie mov2 = query.searchById(idToSearch2);

        assertTrue(movies2.contains(mov2));


        String title3 = "Russia";
        List<Movie> movies3 = query.searchByTitle(title3);

        assertEquals(10, movies3.size());

        String idToSearch3 = "tt0057076";
        Movie mov3 = query.searchById(idToSearch3);

        assertTrue(movies3.contains(mov3));
    }

    @Test
    void searchMovieNotExistByImdbIdTest() {
        String idToSearch1 = "651561dfv";
        Movie movie1 = query.searchById(idToSearch1);
        assertEquals(null, movie1);

        String idToSearch2 = "tt02515";
        Movie movie2 = query.searchById(idToSearch2);
        assertEquals(null, movie2);

        String idToSearch3 = "";
        Movie movie3 = query.searchById(idToSearch3);
        assertEquals(null, movie3);
    }

    @Test
    void searchMovieNotExistByTitleTest() {
        String title = "davdvfd";
        List<Movie> movies = query.searchByTitle(title);

        assertEquals(null, movies);


        String title2 = "";
        List<Movie> movies2 = query.searchByTitle(title2);

        assertEquals(null, movies2);


        String title3 = "aavfvdaas";
        List<Movie> movies3 = query.searchByTitle(title3);

        assertEquals(null, movies3);

    }
}