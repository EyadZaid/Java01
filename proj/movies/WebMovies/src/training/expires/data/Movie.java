package training.expires.data;

import java.util.List;
import java.util.Objects;

public class Movie {
    private final String imdbID;
    private final String title;
    private final String rated;
    private final String runtime;
    private final String year;
    private final List<String> directorsList;
    private final List<String> genreList;

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

    @Override
    public String toString() {
        return "Movie{" +
                "imdbID='" + imdbID + '\'' +
                ", title='" + title + '\'' +
                ", rated='" + rated + '\'' +
                ", runtime='" + runtime + '\'' +
                ", year='" + year + '\'' +
                ", directorsList=" + directorsList +
                ", genreList=" + genreList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(imdbID, movie.imdbID) && Objects.equals(title, movie.title) &&
                Objects.equals(rated, movie.rated) && Objects.equals(runtime, movie.runtime) &&
                Objects.equals(year, movie.year) && Objects.equals(directorsList, movie.directorsList) &&
                Objects.equals(genreList, movie.genreList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imdbID, title, rated, runtime, year, directorsList, genreList);
    }
}
