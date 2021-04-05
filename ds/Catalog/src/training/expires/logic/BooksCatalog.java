package training.expires.logic;

import training.expires.dao.Book;
import training.expires.logic.inputs.FileRead;
import training.expires.logic.inputs.IDataFormat;
import training.expires.logic.inputs.IInputData;
import training.expires.logic.queries.ISearch;
import training.expires.logic.queries.SearchByAuthor;
import training.expires.logic.queries.SearchByIsbn;
import training.expires.logic.queries.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private IInputData inputData;
    private ISearch search;

    public BooksCatalog() {
        allBooks = new HashSet<>();;
    }

    public int amountOfBooks(){
        return allBooks.size();
    }

    public HashSet<Book> getAllBooks() {
        return allBooks;
    }

    public void addBooksFromFile(String fileName, IDataFormat dataFormat) throws FileNotFoundException {
        inputData = new FileRead(fileName);
        String line;
        Book book;

        inputData.readline();
        if (inputData.isEnd()){
            return;
        }
        line = inputData.readline();
        while (!inputData.isEnd()){
            book = dataFormat.inputParse(line);
            allBooks.add(book);
            line = inputData.readline();
        }
        inputData.close();
    }

    public void searchByIsbn(){
        search = new SearchByIsbn(allBooks);
        search.searchFromConsole();
    }

    public void searchByTitle(){
        search = new SearchByTitle(allBooks);
        search.searchFromConsole();
    }

    public void searchByAuthor(){
        search = new SearchByAuthor(allBooks);
        search.searchFromConsole();
    }

    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
