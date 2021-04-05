package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.ArrayList;

public interface ISearch {

    ArrayList<Book> search(String inputSearch);

    void searchFromConsole();
}
