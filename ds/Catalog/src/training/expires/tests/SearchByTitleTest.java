package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchByTitleTest {
    BooksCatalog booksCatalog;
    SearchByTitle searchByTitle;

    @BeforeEach
    void setUp() {
        booksCatalog = BooksCatalog.getInstance();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByTitle = new SearchByTitle();
    }

    @Test
    void searchByTitleOneWordExist() {
        Book book = new Book(new Isbn("887841740"), "The Middle Stories", "Sheila Heti",
                2004, "House of Anansi Press");
        ArrayList<Book> books = searchByTitle.search("middle");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleTwoWordsExist() {
        Book book = new Book(new Isbn("887841740"), "The Middle Stories", "Sheila Heti",
                2004, "House of Anansi Press");
        ArrayList<Book> books = searchByTitle.search("middle stories");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleTwoWordsAndNot() {
        Book book = new Book(new Isbn("887841740"), "The Middle Stories", "Sheila Heti",
                2004, "House of Anansi Press");
        ArrayList<Book> books = searchByTitle.search("middle stories -stor");
        assertTrue(books.contains(book));
    }

    @Test
    void searchByTitleTwoWordsAndNotExist() {
        Book book = new Book(new Isbn("887841740"), "The Middle Stories", "Sheila Heti",
                2004, "House of Anansi Press");
        ArrayList<Book> books = searchByTitle.search("middle stories -stories");
        assertFalse(books.contains(book));
    }

    @Test
    void searchByTitleNothing() {
        ArrayList<Book> books = searchByTitle.search("black -black");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleNotExist() {
        ArrayList<Book> books = searchByTitle.search("asfdfhdf");
        assertTrue(books.isEmpty());
    }

    @Test
    void searchByTitleEmpty() {
        ArrayList<Book> books = searchByTitle.search("");
        assertTrue(books.isEmpty());
    }
}