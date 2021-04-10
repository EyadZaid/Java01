package training.expires.logic.queries;

import training.expires.data.Book;
import training.expires.data.BooksCatalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchByAuthor implements ISearch{
    private BooksCatalog booksCatalog;
    private Map<String, Set<Book>> booksByAuthor;
    private Set<String> includeWords;

    public SearchByAuthor() {
        booksCatalog = BooksCatalog.getInstance();
        booksByAuthor = booksCatalog.getIndex(QueryType.AUTHOR);
        includeWords = new HashSet<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        handleInput(inputSearch);
        HashSet<Book> res = new HashSet<>();
        ArrayList<Book> result = new ArrayList<>();

        for (var word : includeWords){
            Set<Book> booksIncWord = booksByAuthor.get(word);
            if (booksIncWord != null) {
                for (var r : booksIncWord) {
                    if (includeWords.size() > 1) {
                        ArrayList<String> authorList = authorToWordsList(r.getBookAuthor());
                        if (!authorList.containsAll(includeWords)) {
                            continue;
                        }
                    }
                    res.add(r);
                }
            }
        }
        result.addAll(res);
        return result;
    }


    private ArrayList<String> authorToWordsList(String author){
        ArrayList<String> wordsList = new ArrayList<>();
        String bookAuthor = author.toLowerCase();
        String[] wordsAuthor = bookAuthor.split("\\ ");
        for (int i=0; i<wordsAuthor.length; i++){
            String word = wordsAuthor[i];
            if (word.length() > 1){
                wordsList.add(word);
            }
        }
        return wordsList;
    }


    private void handleInput(String inputSearch) {
        String[] words = inputSearch.split("\\ ");
        for (int i=0; i<words.length; i++){
            String word = words[i].toLowerCase();
            if (word.length() > 0 && !word.equals(" ")){
                includeWords.add(word);
            }
        }
    }

}
