package training.expires;

import training.expires.data.BooksCatalog;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {
            BooksCatalog booksCatalog = new BooksCatalog();
            booksCatalog.addAllBooks();
            System.out.println("Enter:");
            System.out.println(booksCatalog.getAllBooks().size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
