package training.expires.ui;

import training.expires.data.Movie;
import training.expires.logic.queries.Query;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Query query;

    public UserInterface(){
        query = Query.getInstance();
    }

    public void executeApp() {
        boolean inputLoop = true;

        while (inputLoop){
            System.out.println("Enter 1 to search by ImdbId");
            System.out.println("Enter 2 to Search by Title");
            System.out.println("Enter 3 to exit");

            Scanner reader = new Scanner(System.in);
            char input = reader.next().charAt(0);

            switch (input){
                case '1' -> searchByImdbId();
                case '2' -> searchByTitle();
                case '3' -> inputLoop = false;
            }
        }
        query.shutdown();
    }


    private void searchByImdbId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter imdbId:");
        String inputSearch = scanner.nextLine();

        Movie movie = query.searchById(inputSearch);

        if (movie != null){
            System.out.println(movie);
        }
        else {
            System.out.println("Movie does not exist");
        }
    }


    private void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title:");
        String inputSearch = scanner.nextLine();

        List<Movie> moviesList = query.searchByTitle(inputSearch);

        if (moviesList != null && moviesList.size() > 0){
            System.out.println(moviesList);
        }
        else {
            System.out.println("Movie does not exist");
        }
    }


}
