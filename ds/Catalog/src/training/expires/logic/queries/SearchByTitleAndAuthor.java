package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchByTitleAndAuthor implements ISearch{
    private HashSet<Book> allBooks;
    private Set<String> includeWords;
    private Set<String> notIncludeWords;
    private String author;

    public SearchByTitleAndAuthor(HashSet<Book> allBooks){
        this.allBooks = allBooks;
        includeWords = new HashSet<>();
        notIncludeWords = new HashSet<>();
    }


    @Override
    public ArrayList<Book> search(String inputSearch) {
        ArrayList<Book> result = new ArrayList<>();
        handleInput(inputSearch);
        for (Book b : allBooks){
            if (!b.getBookAuthor().toLowerCase().equals(author.toLowerCase())) {
                break;
            }
            boolean isSuitable = true;
            String bookTitle = b.getBookTitle();
            ArrayList<String> wordsList = titleToWordsList(bookTitle);
            for (String word : notIncludeWords){
                if (wordsList.contains(word)){
                    isSuitable = false;
                    break;
                }
            }
            if (isSuitable){
                for (String word : includeWords){
                    if (wordsList.contains(word)){
                        result.add(b);
                        break;
                    }
                }
            }
        }
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
        String[] titleAndAuthor = inputSearch.split("author:");
        if (titleAndAuthor.length != 2){
            return;
        }

        String[] words = titleAndAuthor[0].split("\\ ");
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
        author = titleAndAuthor[1];
    }


}
