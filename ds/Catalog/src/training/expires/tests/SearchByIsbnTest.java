package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByAuthor;
import training.expires.logic.queries.SearchByIsbn;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchByIsbnTest {
    BooksCatalog booksCatalog;
    SearchByIsbn searchByIsbn;

    @BeforeEach
    void setUp() {
        booksCatalog = BooksCatalog.getInstance();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByIsbn = new SearchByIsbn();
    }

    @Test
    void searchByIsbnExists() {
        ArrayList<Book> result = searchByIsbn.search("771074670");
        assertEquals(new Isbn("771074670"), result.get(0).getIsbn());
    }

    @Test
    void searchByIsbnExists2() {
        ArrayList<Book> result = searchByIsbn.search("393045218");
        assertEquals(new Isbn("393045218"), result.get(0).getIsbn());
    }

    @Test
    void searchByIsbnNotExists() {
        ArrayList<Book> result = searchByIsbn.search("258045218");
        assertTrue(result.isEmpty());
    }

    @Test
    void searchByIsbnNotEmpty() {
        ArrayList<Book> result = searchByIsbn.search("");
        assertTrue(result.isEmpty());
    }

}