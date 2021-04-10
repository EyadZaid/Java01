package training.expires.logic.queries;

import training.expires.data.Book;
import training.expires.data.BooksCatalog;

import java.util.*;

public class SearchByTitle implements ISearch{
    private BooksCatalog booksCatalog;
    private Map<String, Set<Book>> booksByTitle;
    private Set<String> includeWords;
    private Set<String> notIncludeWords;

    public SearchByTitle(){
        booksCatalog = BooksCatalog.getInstance();
        booksByTitle = booksCatalog.getIndex(QueryType.TITLE);
        includeWords = new HashSet<>();
        notIncludeWords = new HashSet<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        HashSet<Book> res = new HashSet<>();
        ArrayList<Book> result = new ArrayList<>();
        handleInput(inputSearch);

        for (var word : includeWords){
            Set<Book> booksIncWord = booksByTitle.get(word);
            if (booksIncWord != null) {
                for (var r : booksIncWord) {
                    if (includeWords.size() > 1) {
                        ArrayList<String> titleList = titleToWordsList(r.getBookTitle());
                        if (!titleList.containsAll(includeWords)) {
                            continue;
                        }
                    }
                    res.add(r);
                }
            }
        }

        for (var word : notIncludeWords){
            Set<Book> booksUnIncWord = booksByTitle.get(word);
            if (booksUnIncWord != null) {
                res.removeAll(booksUnIncWord);
            }
        }
        result.addAll(res);
        return result;
    }

    private ArrayList<String> titleToWordsList(String title){
        ArrayList<String> wordsList = new ArrayList<>();
        String bookTitle = title.toLowerCase();
        String[] wordsTitle = bookTitle.split("\\ ");
        for (int i=0; i<wordsTitle.length; i++){
            String word = wordsTitle[i];
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
                if (word.charAt(0) == '-'){
                    word = word.substring(1);
                    notIncludeWords.add(word);
                }
                else {
                    includeWords.add(word);
                }
            }
        }
    }

}
