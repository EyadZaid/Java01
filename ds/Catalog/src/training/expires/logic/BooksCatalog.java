package training.expires.logic;

import training.expires.dao.Book;
import training.expires.logic.inputs.FileRead;
import training.expires.logic.inputs.IDataFormat;
import training.expires.logic.inputs.IInputData;
import training.expires.logic.queries.*;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private IInputData inputData;
    private ISearch query;

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
        Book book = null;

        inputData.readline();
        if (inputData.isEnd()){
            return;
        }
        line = inputData.readline();
        while (!inputData.isEnd()){
            try {
                book = dataFormat.inputParse(line);
            } catch (IllegalDataFormatException e) {
                e.printStackTrace();
            }
            if (book != null){
                allBooks.add(book);
            }
            line = inputData.readline();
        }
        inputData.close();
    }

    public ArrayList<Book> searchByIsbn(String inputSearch){
        query = new SearchByIsbn(allBooks);
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByTitle(String inputSearch){
        query = new SearchByTitle(allBooks);
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByAuthor(String inputSearch){
        query = new SearchByAuthor(allBooks);
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByTitleAndAuthor(String inputSearch){
        query = new SearchByTitleAndAuthor(allBooks);
        return query.search(inputSearch);
    }

    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
