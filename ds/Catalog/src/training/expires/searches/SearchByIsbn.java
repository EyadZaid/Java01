package training.expires.searches;

import training.expires.data.Book;

import java.util.HashSet;
import java.util.Scanner;

public class SearchByIsbn implements ISearch{
    private HashSet<Book> allBooks;

    public SearchByIsbn(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Book search(String isbn){
        for (Book b: allBooks){
            if (b.getIsbn().equals(isbn)){
                return b;
            }
        }
        return null;
    }

    @Override
    public void searchFromConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn:");
        String isbn = scanner.nextLine();
        Book book = search(isbn);
        if (book != null){
            System.out.println(book.displayByLines());
        }
        else {
            System.out.println("Book does not exist");
        }
    }
}