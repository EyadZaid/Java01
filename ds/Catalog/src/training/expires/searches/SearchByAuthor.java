package training.expires.searches;

import training.expires.data.Book;

import java.util.HashSet;
import java.util.Scanner;

public class SearchByAuthor implements ISearch{

    private HashSet<Book> allBooks;

    public SearchByAuthor(HashSet<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Book search(String author){
        for (Book b: allBooks){
            if (b.getBookAuthor().toLowerCase().equals(author.toLowerCase())){
                return b;
            }
        }
        return null;
    }

    @Override
    public void searchFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book author name:");
        String author = scanner.nextLine();
        Book book = search(author);
        if (book != null){
            System.out.println(book.displayByLines());
        }
        else {
            System.out.println("Book does not exist");
        }
    }
}
