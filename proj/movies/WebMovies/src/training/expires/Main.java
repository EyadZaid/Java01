package training.expires;

import training.expires.logic.queries.QueryType;
import training.expires.logic.queries.UserQuery;

public class Main {

    public static void main(String[] args) {

        UserQuery query = UserQuery.getInstance();

        System.out.println(query.searchById("tt0412142"));
        System.out.println(query.searchById("tt0220264"));
        System.out.println(query.searchByTitle("soul"));
        query.shutdown();
    }

}
