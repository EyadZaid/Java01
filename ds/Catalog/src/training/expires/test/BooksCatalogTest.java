package training.expires.test;

import org.junit.jupiter.api.BeforeEach;
import training.expires.BooksCatalog;
import training.expires.data.Book;
import training.expires.data.Isbn;
import training.expires.inputs.InputParser;
import training.expires.searches.SearchByIsbn;
import training.expires.searches.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BooksCatalogTest {

    BooksCatalog booksCatalog;
    SearchByIsbn searchByIsbn;
    SearchByTitle searchByTitle;

    @BeforeEach
    void setup() {
        booksCatalog = new BooksCatalog();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        searchByIsbn = new SearchByIsbn(booksCatalog.getAllBooks());
        searchByTitle = new SearchByTitle(booksCatalog.getAllBooks());
    }

    @org.junit.jupiter.api.Test
    void getAllBooks() {
        assertTrue(booksCatalog.amountOfBooks() > 0);
    }

    @org.junit.jupiter.api.Test
    void searchByIsbn() {
        Book book = searchByIsbn.search(new Isbn("771074670"));
        assertEquals(new Isbn("771074670"), book.getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByIsbn2() {
        Book book = searchByIsbn.search(new Isbn("393045218"));
        assertEquals(new Isbn("393045218"), book.getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle() {
        ArrayList<Book> books = searchByTitle.search("middle black -black");
        assertEquals(new Isbn("446677450"), books.get(0).getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle2() {
        ArrayList<Book> books = searchByTitle.search("black -black");
        assertEquals(0, books.size());
    }
}