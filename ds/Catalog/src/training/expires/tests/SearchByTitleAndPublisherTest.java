package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByTitleAndAuthor;
import training.expires.logic.queries.SearchByTitleAndPublisher;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchByTitleAndPublisherTest {
    BooksCatalog booksCatalog;
    SearchByTitleAndPublisher searchByTitleAndPublisher;

    @BeforeEach
    void setUp() {
        booksCatalog = BooksCatalog.getInstance();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByTitleAndPublisher = new SearchByTitleAndPublisher();
    }

    @Test
    void searchByTitleAndPublisherFirstName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black publisher:Warner");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndPublisherFullName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black publisher:Warner Books");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndPublisherLastName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black publisher:books");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByPublisherLastNameAndTitle() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndPublisher.search("publisher:books house -black");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndPublisherNotExists() {
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black publisher:dssfgdf");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleAndPublisherEmpty() {
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black publisher:");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleAndPublisherEmpty2() {
        ArrayList<Book> books = searchByTitleAndPublisher.search("house -black");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleEmptyAndPublisher() {
        ArrayList<Book> books = searchByTitleAndPublisher.search("publisher:patterson");
        assertTrue(books.isEmpty());
    }

}