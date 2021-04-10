package training.expires.data;

import training.expires.logic.IllegalDataFormatException;
import training.expires.logic.inputs.FileRead;
import training.expires.logic.inputs.IDataFormat;
import training.expires.logic.inputs.IInputData;
import training.expires.logic.queries.*;

import java.io.FileNotFoundException;
import java.util.*;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private Map<QueryType, Index<String,Set<Book>>> indices;
    private static final BooksCatalog catalog = new BooksCatalog();

    public static BooksCatalog getInstance(){
        return catalog;
    }

    private IInputData inputData;
    private ISearch query;


    private BooksCatalog() {
        allBooks = new HashSet<>();;
        indices = new HashMap<>();
        for (var qType : QueryType.values()){
            indices.put(qType, new Index<>());
        }
    }

    public int amountOfBooks(){
        return allBooks.size();
    }

    public Map<String, Set<Book>> getIndex(QueryType type){
        return indices.get(type);
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
                HashSet<Book> isbnSet = new HashSet<>();
                isbnSet.add(book);
                indices.get(QueryType.ISBN).put(book.getIsbn().toString(), isbnSet);
                addAuthor(book);
                addTitle(book);
                addPublisher(book);
            }
            line = inputData.readline();
        }
        inputData.close();
    }

    private void addAuthor(Book book){
        String[] authorWords = book.getBookAuthor().split("\\ ");
        var authorIndex = indices.get(QueryType.AUTHOR);
        for (var word : authorWords){
            if (word.equals("") || word.equals(" ")){
                continue;
            }
            word = word.toLowerCase();
            if (!authorIndex.containsKey(word)){
                HashSet<Book> authorSet = new HashSet<>();
                authorSet.add(book);
                authorIndex.put(word, authorSet);
            }
            else {
                authorIndex.get(word).add(book);
            }
        }
    }

    private void addTitle(Book book){
        String[] titleWords = book.getBookTitle().split("\\ ");
        var titleIndex = indices.get(QueryType.TITLE);
        for (var word : titleWords){
            if (word.equals("") || word.equals(" ")){
                continue;
            }
            word = word.toLowerCase();
            if (!titleIndex.containsKey(word)){
                HashSet<Book> titleSet = new HashSet<>();
                titleSet.add(book);
                titleIndex.put(word, titleSet);
            }
            else {
                titleIndex.get(word).add(book);
            }
        }
    }

    private void addPublisher(Book book){
        String[] publisherWords = book.getPublisher().split("\\ ");
        var publisherIndex = indices.get(QueryType.PUBLISHER);
        for (var word : publisherWords){
            if (word.equals("") || word.equals(" ")){
                continue;
            }
            word = word.toLowerCase();
            if (!publisherIndex.containsKey(word)){
                HashSet<Book> publisherSet = new HashSet<>();
                publisherSet.add(book);
                publisherIndex.put(word, publisherSet);
            }
            else {
                publisherIndex.get(word).add(book);
            }
        }
    }

    public ArrayList<Book> searchByIsbn(String inputSearch){
        query = new SearchByIsbn();
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByTitle(String inputSearch){
        query = new SearchByTitle();
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByAuthor(String inputSearch){
        query = new SearchByAuthor();
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByTitleAndAuthor(String inputSearch){
        query = new SearchByTitleAndAuthor();
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByPublisher(String inputSearch){
        query = new SearchByPublisher();
        return query.search(inputSearch);
    }

    public ArrayList<Book> searchByTitleAndPublisher(String inputSearch){
        query = new SearchByTitleAndPublisher();
        return query.search(inputSearch);
    }

    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
