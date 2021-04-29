package training.expires.ui;

import training.expires.logic.QueryResults;
import training.expires.logic.outputs.ConsoleWrite;
import training.expires.logic.outputs.FileWrite;
import training.expires.logic.outputs.IOutput;
import training.expires.logic.QueryManager;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private QueryManager queryManager;
    private final Scanner reader;
    private boolean activeResults;
    private IOutput output;

    public UserInterface(){
        reader = new Scanner(System.in);
    }

    public void executeApp() {
        selectDisplay();
        queryManager = new QueryManager(new QueryResults(output));
        activeResults = true;
        runGetResults();
        boolean inputLoop = true;

        while (inputLoop){
            System.out.println("Enter 1 to search by ImdbId");
            System.out.println("Enter 2 to Search by Title");
            System.out.println("Enter 3 to exit");

            char input = reader.next().charAt(0);
            switch (input){
                case '1' -> searchByImdbId();
                case '2' -> searchByTitle();
                case '3' -> inputLoop = false;
            }
        }
        activeResults = false;
        queryManager.shutdown();
        output.close();
    }

    private void searchByImdbId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter imdbId:");
        String inputSearch = scanner.nextLine();

        queryManager.searchById(inputSearch);
    }

    private void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String inputSearch = scanner.nextLine();

       queryManager.searchByTitle(inputSearch);
    }

    private void selectDisplay() {
        System.out.println("Enter 1 to display results in console");
        System.out.println("Enter 2 to display results in file");
        char input = reader.next().charAt(0);
        if (input == '2') {
            try {
                output = new FileWrite("output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            output = new ConsoleWrite();
        }
    }

    private void runGetResults() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (activeResults) {
                    queryManager.getResults();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
