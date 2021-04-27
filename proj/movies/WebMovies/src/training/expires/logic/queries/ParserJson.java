package training.expires.logic.queries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import training.expires.data.Movie;

import java.util.Arrays;
import java.util.List;

 class ParserJson implements IParser {

    public ParserJson() {
    }

    @Override
    public Movie parse(String jsonString) {
        if (!isJSONValid(jsonString)) {
            return null;
        }

        JSONObject obj = new JSONObject(jsonString);
        if (obj.has("Response") && !obj.getBoolean("Response")) {
            return null;
        }

        String imdbId = obj.getString("imdbID");
        String title = obj.getString("Title");
        String rated = obj.getString("Rated");
        String runtime = obj.getString("Runtime");
        String year = obj.getString("Year");

        String directors = obj.getString("Director");
        List<String> directorsList = Arrays.asList(directors.split("\\s*,\\s*"));

        String genres = obj.getString("Genre");
        List<String> genreList = Arrays.asList(genres.split("\\s*,\\s*"));

        Movie movie = new Movie(imdbId, title, rated, runtime, year, directorsList, genreList);
        return movie;
    }


     private boolean isJSONValid(String test) {
         try {
             new JSONObject(test);
         } catch (JSONException ex) {
             try {
                 new JSONArray(test);
             } catch (JSONException ex1) {
                 return false;
             }
         }
         return true;
     }
 }
