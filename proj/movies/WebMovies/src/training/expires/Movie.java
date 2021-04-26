package training.expires;

import java.util.List;

public class Movie {
    private String imdbID;
    private String title;
    private String rated;
    private String runtime;
    private String year;
    private List<String> directorsList;
    private List<String> genreList;

    public Movie(String imdbID, String title, String rated, String runtime, String year,
                 List<String> directorsList, List<String> genreList) {
        this.imdbID = imdbID;
        this.title = title;
        this.rated = rated;
        this.runtime = runtime;
        this.year = year;
        this.directorsList = directorsList;
        this.genreList = genreList;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
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
