package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByAuthor;
import training.expires.logic.queries.SearchByPublisher;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchByPublisherTest {
    BooksCatalog booksCatalog;
    SearchByPublisher searchByPublisher;

    @BeforeEach
    void setUp() {
        booksCatalog = BooksCatalog.getInstance();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByPublisher = new SearchByPublisher();
    }


    @Test
    void searchByPublisherFullName() {
        Book book = new Book(new Isbn("452279690"), "Cavedweller", "Dorothy Allison",
                1999, "Plume Books");
        ArrayList<Book> books = searchByPublisher.search("plume books");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByAuthorFirstName() {
        Book book = new Book(new Isbn("452279690"), "Cavedweller", "Dorothy Allison",
                1999, "Plume Books");
        ArrayList<Book> books = searchByPublisher.search("plume");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByAuthorLastName() {
        Book book = new Book(new Isbn("452279690"), "Cavedweller", "Dorothy Allison",
                1999, "Plume Books");
        ArrayList<Book> books = searchByPublisher.search("Books");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByAuthorEmpty() {
        ArrayList<Book> books = searchByPublisher.search("");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByAuthorNotExists() {
        ArrayList<Book> books = searchByPublisher.search("abcde");
        assertTrue(books.isEmpty());
    }
}