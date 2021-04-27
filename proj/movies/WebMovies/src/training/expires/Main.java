package training.expires;

import training.expires.logic.queries.Query;

public class Main {

    public static void main(String[] args) {

        Query query = Query.getInstance();

        System.out.println(query.searchById("tt0412142"));
        System.out.println(query.searchById("tt0220264"));
        System.out.println(query.searchByTitle("soul"));
        query.shutdown();
    }

}
