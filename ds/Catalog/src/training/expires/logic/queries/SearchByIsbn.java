package training.expires.logic.queries;

import training.expires.dao.Book;
import training.expires.dao.Isbn;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchByIsbn implements ISearch{
    private HashSet<Book> allBooks;

    public SearchByIsbn(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        ArrayList<Book> result = new ArrayList<>();
        Isbn isbn = new Isbn(inputSearch);
        for (Book b: allBooks){
            if (b.getIsbn().equals(isbn)){
                result.add(b);
                break;
            }
        }
        return result;
    }

}
