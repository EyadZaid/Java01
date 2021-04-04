package training.expires;

import training.expires.data.Book;
import training.expires.inputs.FileRead;
import training.expires.inputs.InputParser;
import training.expires.searches.SearchByIsbn;
import training.expires.searches.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private FileRead fileRead;
    private InputParser inputParser;


    public BooksCatalog(String fileName) throws FileNotFoundException {
        allBooks = new HashSet<>();;
        fileRead = new FileRead(fileName);
        inputParser = new InputParser();
    }

    public boolean addBook(Book book){
        return allBooks.add(book);
    }

    public int amountOfBooks(){
        return allBooks.size();
    }

    public HashSet<Book> getAllBooks() {
        return allBooks;
    }

    public void addBooksFromFile(){
        String line;
        Book book;
        Boolean isFirstLine = true;

        fileRead.readline();
        if (fileRead.isEnd()){
            return;
        }
        line = fileRead.readline();
        while (!fileRead.isEnd()){
            book = inputParser.consoleParse(line);
            allBooks.add(book);
            line = fileRead.readline();
        }
        fileRead.close();
    }

    public void searchByIsbn(){
        SearchByIsbn searchByIsbn = new SearchByIsbn(allBooks);
        searchByIsbn.searchFromConsole();
    }

    public void searchByTitle(){
        SearchByTitle searchByTitle = new SearchByTitle(allBooks);
        searchByTitle.searchFromConsole();
    }


    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
