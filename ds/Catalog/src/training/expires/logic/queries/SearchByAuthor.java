package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchByAuthor implements ISearch{

    private HashSet<Book> allBooks;
    private ArrayList<Book> result;
    private Set<String> includeWords;

    public SearchByAuthor(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
        result = new ArrayList<>();
        includeWords = new HashSet<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        handleInput(inputSearch);
        for (Book b: allBooks){
            boolean isSuitable = false;
            String bookAuthor = b.getBookAuthor();
            ArrayList<String> wordsList = authorToWordsList(bookAuthor);
            for (String word : includeWords){
                if (wordsList.contains(word)){
                    isSuitable = true;
                }
                else {
                    isSuitable = false;
                    break;
                }
            }
            if (isSuitable){
                result.add(b);
            }
        }
        return result;
    }


    private ArrayList<String> authorToWordsList(String author){
        ArrayList<String> wordsList = new ArrayList<>();
        String bookTitle = author.toLowerCase();
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
                includeWords.add(word);
            }
        }
    }

}
