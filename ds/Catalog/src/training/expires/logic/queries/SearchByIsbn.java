package training.expires.logic.queries;

import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.data.Isbn;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class SearchByIsbn implements ISearch{
    private BooksCatalog booksCatalog;
    private Map<String, Set<Book>> booksByIsbn;


    public SearchByIsbn() {
        booksCatalog = BooksCatalog.getInstance();
        booksByIsbn = booksCatalog.getIndex(QueryType.ISBN);
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        ArrayList<Book> result = new ArrayList<>();
        Isbn isbn = new Isbn(inputSearch);
        Set<Book> resultSet = booksByIsbn.get(isbn.toString());
        if (resultSet != null){
            result.addAll(resultSet);
        }
        return result;
    }

}
