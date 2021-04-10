package training.expires.ui;

import training.expires.data.Book;
import training.expires.data.BooksCatalog;
import training.expires.logic.inputs.InputParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private BooksCatalog booksCatalog;

    public UserInterface(){
        booksCatalog = BooksCatalog.getInstance();
    }

    public void executeApp() {
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
            System.out.println("Enter 4 to Search by Publisher");
            System.out.println("Enter 5 to Search by title and Author");
            System.out.println("Enter 6 to Search by title and Publisher");
            System.out.println("Enter 7 to exit");

            Scanner reader = new Scanner(System.in);
            char input = reader.next().charAt(0);

            switch (input){
                case '1' -> searchByIsbn();
                case '2' -> searchByTitle();
                case '3' -> searchByAuthor();
                case '4' -> searchByPublisher();
                case '5' -> searchByTitleAndAuthor();
                case '6' -> searchByTitleAndPublisher();
                case '7' -> inputLoop = false;
            }
        }
    }


    private void searchByIsbn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter isbn:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> result = booksCatalog.searchByIsbn(inputSearch);
        if (result.size() > 0){
            System.out.println(result.get(0).displayByLines());
        }
        else {
            System.out.println("Book does not exist");
        }
    }


    public void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = booksCatalog.searchByTitle(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    public void searchByAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book author name:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = booksCatalog.searchByAuthor(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    public void searchByPublisher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book publisher:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = booksCatalog.searchByPublisher(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    public void searchByTitleAndAuthor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title and author name:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = booksCatalog.searchByTitleAndAuthor(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    public void searchByTitleAndPublisher(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title and publisher:");
        String inputSearch = scanner.nextLine();
        ArrayList<Book> books = booksCatalog.searchByTitleAndPublisher(inputSearch);
        if (books.size() > 0){
            printResult(books);
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    private void printResult(ArrayList<Book> books) {
        for (Book b : books) {
            System.out.println(b.display());
        }
    }

}
