package training.expires.logic.queries;

import training.expires.data.Book;

import java.util.ArrayList;

public class SearchByTitleAndPublisher implements ISearch{
    private String inputAuthor;
    private String inputTitle;

    public SearchByTitleAndPublisher(){
        inputAuthor = "";
        inputTitle = "";
    }

    @Override
    public ArrayList<Book> search(String inputSearch) {
        handleInput(inputSearch);
        ArrayList<Book> resultByPublisher = new SearchByPublisher().search(inputAuthor);
        ArrayList<Book> resultByTitle = new SearchByTitle().search(inputTitle);
        ArrayList result = new ArrayList<>();

        for (var res : resultByPublisher) {
            if (resultByTitle.contains(res)) {
                result.add(res);
            }
        }
        return result;
    }

    private void handleInput(String inputSearch) {
        String[] titleAndAuthor = inputSearch.split("publisher:");
        if (titleAndAuthor.length == 2 && titleAndAuthor[0] != ""){
            inputTitle = titleAndAuthor[0];
            inputAuthor = titleAndAuthor[1];
        }
        else{
            if (titleAndAuthor.length == 2) {
                titleAndAuthor = titleAndAuthor[1].split("\\ ", 2);
                if (titleAndAuthor.length == 2) {
                    inputAuthor = titleAndAuthor[0];
                    inputTitle = titleAndAuthor[1];
                }
            }
        }
    }
}
