package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.*;

public class SearchByTitle implements ISearch{
    private HashSet<Book> allBooks;
    private ArrayList<Book> result;
    private Set<String> includeWords;
    private Set<String> notIncludeWords;

    public SearchByTitle(HashSet<Book> allBooks){
        this.allBooks = allBooks;
        includeWords = new HashSet<>();
        notIncludeWords = new HashSet<>();
        result = new ArrayList<>();
    }

    public ArrayList<Book> search(String inputSearch){
        handleInput(inputSearch);

        for (Book b : allBooks){
            List<String> wordsList = new ArrayList<>();
            boolean isSuitable = true;
            String bookTitle = b.getBookTitle().toLowerCase();
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

    @Override
    public void searchFromConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = search(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    private void printResult(ArrayList<Book> books){
        for (Book b : books){
            System.out.println(b.display());
        }

    }
}
