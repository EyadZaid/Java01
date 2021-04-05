package training.expires;

import training.expires.dao.Book;
import training.expires.inputs.FileRead;
import training.expires.inputs.IDataFormat;
import training.expires.inputs.IInputData;
import training.expires.searches.ISearch;
import training.expires.searches.SearchByAuthor;
import training.expires.searches.SearchByIsbn;
import training.expires.searches.SearchByTitle;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private IInputData inputData;
    private ISearch search;

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
            /*
            if (book.getIsbn().checkValidIsbn()){

            }
             */

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
