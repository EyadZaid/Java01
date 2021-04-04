package training.expires.test;

import org.junit.jupiter.api.BeforeEach;
import training.expires.BooksCatalog;
import training.expires.data.Book;
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
        try {
            booksCatalog = new BooksCatalog("books-small.txt");
            booksCatalog.addBooksFromFile();

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
        Book book = searchByIsbn.search("771074670");
        assertEquals("771074670", book.getIsbn());
    }

    @org.junit.jupiter.api.Test
    void searchByTitle() {
        ArrayList<Book> books = searchByTitle.search("middle black -black");
        assertEquals("887841740", books.get(0).getIsbn());
    }
}