package training.expires.logic.queries;

import training.expires.dao.Book;
import training.expires.dao.Isbn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SearchByIsbn implements ISearch{
    private HashSet<Book> allBooks;

    public SearchByIsbn(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
    }

    @Override
    public ArrayList<Book> search(String inputSearch){
        ArrayList<Book> result = new ArrayList<>();
        Isbn isbn = new Isbn(inputSearch);
        for (Book b: allBooks){
            if (b.getIsbn().equals(isbn)){
                result.add(b);
                break;
            }
        }
        return result;
    }

    @Override
    public void searchFromConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> result = search(inputSearch);
        if (result.size() > 0){
            System.out.println(result.get(0).displayByLines());
        }
        else {
            System.out.println("Book does not exist");
        }
    }
}
