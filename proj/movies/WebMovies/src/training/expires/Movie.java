package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private int year;
    private String rated;
    private String imdbID;
    private List<String> directorsList;


    public Movie(String title, int year, String rated, String imdbID) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.imdbID = imdbID;
        this.directorsList = new ArrayList<>();
    }
}
