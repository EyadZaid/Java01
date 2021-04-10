package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByTitleAndAuthor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchByTitleAndAuthorTest {
    BooksCatalog booksCatalog;
    SearchByTitleAndAuthor searchByTitleAndAuthor;

    @BeforeEach
    void setUp() {
        booksCatalog = BooksCatalog.getInstance();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByTitleAndAuthor = new SearchByTitleAndAuthor();
    }

    @Test
    void searchByTitleAndAuthorFirstName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:James");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndAuthorFullName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:James Patterson");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndAuthorLastName() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:patterson");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByAuthorLastNameAndTitle() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndAuthor.search("author:patterson house -black");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleAndAuthorNotExists() {
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:dssfgdf");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleAndAuthorEmpty() {
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleAndAuthorEmpty2() {
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleEmptyAndAuthor() {
        ArrayList<Book> books = searchByTitleAndAuthor.search("author:patterson");
        assertTrue(books.isEmpty());
    }

}