package training.expires.test;

import org.junit.jupiter.api.BeforeEach;
import training.expires.logic.BooksCatalog;
import training.expires.dao.Book;
import training.expires.dao.Isbn;
import training.expires.logic.inputs.InputParser;
import training.expires.logic.queries.SearchByAuthor;
import training.expires.logic.queries.SearchByIsbn;
import training.expires.logic.queries.SearchByTitle;
import training.expires.logic.queries.SearchByTitleAndAuthor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BooksCatalogTest {

    BooksCatalog booksCatalog;
    SearchByIsbn searchByIsbn;
    SearchByTitle searchByTitle;
    SearchByAuthor searchByAuthor;
    SearchByTitleAndAuthor searchByTitleAndAuthor;

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
        searchByTitleAndAuthor = new SearchByTitleAndAuthor(booksCatalog.getAllBooks());
    }

    @org.junit.jupiter.api.Test
    void getAllBooks() {
        assertTrue(booksCatalog.amountOfBooks() > 0);
    }

    @org.junit.jupiter.api.Test
    void searchByIsbn() {
        ArrayList<Book> result = searchByIsbn.search("771074670");
        assertEquals(new Isbn("771074670"), result.get(0).getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByIsbn2() {
        ArrayList<Book> result = searchByIsbn.search("393045218");
        assertEquals(new Isbn("393045218"), result.get(0).getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle() {
        Book book = new Book(new Isbn("887841740"), "The Middle Stories", "Sheila Heti",
                2004, "House of Anansi Press");
        ArrayList<Book> books = searchByTitle.search("middle");
        assertTrue(books.contains(book));
    }

    @org.junit.jupiter.api.Test
    void searchByTitle2() {
        ArrayList<Book> books = searchByTitle.search("black -black");
        assertEquals(0, books.size());
    }

    @org.junit.jupiter.api.Test
    void searchByAuthor() {
        Book book = new Book(new Isbn("452279690"), "Cavedweller", "Dorothy Allison",
                1999, "Plume Books");
        ArrayList<Book> books = searchByAuthor.search("Dorothy Allison");
        assertTrue(books.contains(book));
    }

    @org.junit.jupiter.api.Test
    void searchByAuthor2() {
        Book book = new Book(new Isbn("452279690"), "Cavedweller", "Dorothy Allison",
                1999, "Plume Books");
        ArrayList<Book> books = searchByAuthor.search("dorothy");
        assertTrue(books.contains(book));
    }

    @org.junit.jupiter.api.Test
    void setSearchByTitleAndAuthor() {
        Book book = new Book(new Isbn("446612545"), "The Beach House", "James Patterson",
                2003, "Warner Books");
        ArrayList<Book> books = searchByTitleAndAuthor.search("house -black author:James");
        assertTrue(books.contains(book));
    }


}