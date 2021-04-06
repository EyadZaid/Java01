package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchByAuthor implements ISearch{

    private HashSet<Book> allBooks;
    private ArrayList<Book> result;

    public SearchByAuthor(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
        result = new ArrayList<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        for (Book b: allBooks){
            if (b.getBookAuthor().toLowerCase().equals(inputSearch.toLowerCase())){
                result.add(b);
            }
        }
        return result;
    }

}
