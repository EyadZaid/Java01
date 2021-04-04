package training.expires.inputs;

import training.expires.data.Book;
import training.expires.data.Isbn;

public class InputParser implements IDataFormat {

    @Override
    public Book inputParse(String line){

        String[] details = line.split("\\|");
        if (details.length != 5){
            return null;
        }
        String isbn = details[0];
        String bookTitle = details[1];
        String bookAuthor = details[2];
        int yearOfPublication = Integer.parseInt(details[3]);
        String publisher = details[4];
        return new Book(new Isbn(isbn), bookTitle, bookAuthor, yearOfPublication, publisher);
    }
}
