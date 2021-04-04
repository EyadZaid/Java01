package training.expires.searches;

import training.expires.data.Book;

import java.util.*;

public class SearchByTitle implements ISearch{
    private HashSet<Book> allBooks;
    private ArrayList<Book> result;
    private ArrayList<String> includeWords;
    private ArrayList<String> notIncludeWords;

    public SearchByTitle(HashSet<Book> allBooks){
        this.allBooks = allBooks;
        includeWords = new ArrayList<>();
        notIncludeWords = new ArrayList<>();
        result = new ArrayList<>();
    }

    public ArrayList<Book> search(String inputSearch){
        handleInput(inputSearch);

        for (Book b : allBooks){
            boolean isSuitable = true;
            String bookTitle = b.getBookTitle().toLowerCase();
            String[] wordsTitle = bookTitle.split("\\ ");
            List<String> wordsList = Arrays.asList(wordsTitle);

            for (int i=0; i<notIncludeWords.size(); i++){
                if (wordsList.contains(notIncludeWords.get(i))){
                    isSuitable = false;
                    break;
                }
            }
            if (isSuitable){
                for (int i=0; i<includeWords.size(); i++){
                    if (wordsList.contains(includeWords.get(i))){
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
