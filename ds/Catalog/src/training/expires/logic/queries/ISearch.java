package training.expires.logic.queries;

import training.expires.data.Book;

import java.util.ArrayList;

public interface ISearch {

    ArrayList<Book> search(String inputSearch);

}
