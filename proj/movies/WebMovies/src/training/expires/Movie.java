package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String imdbID;
    private String title;
    private String rated;
    private String runtime;
    private int year;
    private List<String> directorsList;
    private List<String> genreList;


    public Movie(String title, int year, String rated, String imdbID) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.imdbID = imdbID;
        this.directorsList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getImdbID() {
        return imdbID;
    }

    public List<String> getDirectorsList() {
        return directorsList;
    }
}
