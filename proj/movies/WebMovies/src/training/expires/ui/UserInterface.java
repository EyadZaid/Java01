package training.expires.ui;

import training.expires.data.Movie;
import training.expires.logic.outputs.ConsoleWrite;
import training.expires.logic.outputs.FileWrite;
import training.expires.logic.outputs.IOutput;
import training.expires.logic.queries.Query;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Query query;
    private final Scanner reader;
    private IOutput output;

    public UserInterface(){
        query = Query.getInstance();
        reader = new Scanner(System.in);
    }

    public void executeApp() {
        selectDisplay();
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
        query.shutdown();
        output.close();
    }

    private void searchByImdbId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter imdbId:");
        String inputSearch = scanner.nextLine();

        Movie movie = query.searchById(inputSearch);

        if (movie != null){
            output.write(movie.toString());
        }
        else {
            output.write("Movie does not exist");
        }
    }

    private void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String inputSearch = scanner.nextLine();

        List<Movie> moviesList = query.searchByTitle(inputSearch);

        if (moviesList != null && moviesList.size() > 0){
            output.write(moviesList.toString());
        }
        else {
            output.write("Movie does not exist");
        }
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

}
