package training.expires.ui;

import training.expires.logic.BooksCatalog;
import training.expires.logic.inputs.InputParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {

    public void executeApp() {
        BooksCatalog booksCatalog = new BooksCatalog();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean inputLoop = true;

        while (inputLoop){
            System.out.println("Enter 1 to search by ISBN");
            System.out.println("Enter 2 to Search by Title");
            System.out.println("Enter 3 to Search by Author");
            System.out.println("Enter 4 to exit");

            Scanner reader = new Scanner(System.in);
            char input = reader.next().charAt(0);

            switch (input){
                case '1' -> booksCatalog.searchByIsbn();
                case '2' -> booksCatalog.searchByTitle();
                case '3' -> booksCatalog.searchByAuthor();
                case '4' -> inputLoop = false;
            }
        }
    }
}
