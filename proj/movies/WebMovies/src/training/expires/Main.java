package training.expires;

import training.expires.ui.UserInterface;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        ui.executeApp();

        /*
        Query query = Query.getInstance();

        System.out.println(query.searchById("tt0412142"));
        System.out.println(query.searchById("tt0220264"));
        System.out.println(query.searchByTitle("soul"));
        query.shutdown();
         */
    }

}
