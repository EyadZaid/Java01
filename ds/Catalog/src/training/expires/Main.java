package training.expires;

import training.expires.inputs.InputParser;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        executeApp();
    }

    private static void executeApp() {
        BooksCatalog booksCatalog = new BooksCatalog();
        try {
            booksCatalog.addBooksFromFile("books-small.txt", new InputParser());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean inputLoop = true;

        while (inputLoop){
            System.out.println("Enter 1. to search by ISBN");
            System.out.println("Enter 2. to Search by Title");
            System.out.println("Enter 3. to exit");

            Scanner reader = new Scanner(System.in);
            char input = reader.next().charAt(0);

            switch (input){
                case '1' -> booksCatalog.searchByIsbn();

                case '2' -> booksCatalog.searchByTitle();

                case '3' -> inputLoop = false;
            }
        }
    }
}
