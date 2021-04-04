package training.expires;

import training.expires.data.Book;
import training.expires.inputs.FileRead;
import training.expires.inputs.IDataFormat;
import training.expires.inputs.IInputData;
import training.expires.inputs.InputParser;
import training.expires.searches.SearchByIsbn;
import training.expires.searches.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private IInputData inputData;

    public BooksCatalog() {
        allBooks = new HashSet<>();;
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

    public void addBooksFromFile(String fileName, IDataFormat dataFormat) throws FileNotFoundException {
        inputData = new FileRead(fileName);
        String line;
        Book book;
        Boolean isFirstLine = true;

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
