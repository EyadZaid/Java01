package training.expires.logic.queries;

import training.expires.data.Book;
import training.expires.data.BooksCatalog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchByPublisher implements ISearch{
    private BooksCatalog booksCatalog;
    private Map<String, Set<Book>> booksByPublisher;
    private Set<String> includeWords;

    public SearchByPublisher() {
        booksCatalog = BooksCatalog.getInstance();
        booksByPublisher = booksCatalog.getIndex(QueryType.PUBLISHER);
        includeWords = new HashSet<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch) {
        handleInput(inputSearch);
        HashSet<Book> res = new HashSet<>();
        ArrayList<Book> result = new ArrayList<>();

        for (var word : includeWords){
            Set<Book> booksIncWord = booksByPublisher.get(word);
            if (booksIncWord != null) {
                for (var r : booksIncWord) {
                    if (includeWords.size() > 1) {
                        ArrayList<String> publisherList = publisherToWordsList(r.getPublisher());
                        if (!publisherList.containsAll(includeWords)) {
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

    private ArrayList<String> publisherToWordsList(String publisher){
        ArrayList<String> wordsList = new ArrayList<>();
        String bookPublisher = publisher.toLowerCase();
        String[] wordsPublisher = bookPublisher.split("\\ ");
        for (int i=0; i<wordsPublisher.length; i++){
            String word = wordsPublisher[i];
            if (word.length() > 1){
                char ch = word.charAt(word.length()-1);
                if (ch == '.' || ch == ','){
                    word = word.substring(0, word.length()-1);
                }
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
