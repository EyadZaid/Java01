package training.expires.test;

import org.junit.jupiter.api.BeforeEach;
import training.expires.BooksCatalog;
import training.expires.dao.Book;
import training.expires.dao.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByAuthor;
import training.expires.logic.queries.SearchByIsbn;
import training.expires.logic.queries.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BooksCatalogTest {

    BooksCatalog booksCatalog;
    SearchByIsbn searchByIsbn;
    SearchByTitle searchByTitle;
    SearchByAuthor searchByAuthor;

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
        searchByAuthor = new SearchByAuthor(booksCatalog.getAllBooks());
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
        assertEquals(new Isbn("887841740"), books.get(0).getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle2() {
        ArrayList<Book> books = searchByTitle.search("black -black");
        assertEquals(0, books.size());
    }

    @org.junit.jupiter.api.Test
    void searchByAuthor() {
        ArrayList<Book> books = searchByAuthor.search("Dr. Seuss");
        assertEquals(new Isbn("039480001X"), books.get(0).getIsbn());
    }

}