package training.expires.logic.queries;

import training.expires.dao.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SearchByAuthor implements ISearch{

    private HashSet<Book> allBooks;
    private ArrayList<Book> result;

    public SearchByAuthor(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
        result = new ArrayList<>();
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        for (Book b: allBooks){
            if (b.getBookAuthor().toLowerCase().equals(inputSearch.toLowerCase())){
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public void searchFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book author name:");
        String author = scanner.nextLine();
        ArrayList<Book> books = search(author);
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
