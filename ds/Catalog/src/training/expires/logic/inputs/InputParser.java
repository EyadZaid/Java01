package training.expires.logic.inputs;

import training.expires.data.Book;
import training.expires.data.Isbn;
import training.expires.logic.IllegalDataFormatException;

public class InputParser implements IDataFormat {

    @Override
    public Book inputParse(String line) throws IllegalDataFormatException{

        String[] details = line.split("\\|");
        if (details.length != 5){
            throw new IllegalDataFormatException("Invalid file format");
        }
        String isbn = details[0];
        String bookTitle = details[1];
        String bookAuthor = details[2];
        int yearOfPublication = Integer.parseInt(details[3]);
        String publisher = details[4];
        return new Book(new Isbn(isbn), bookTitle, bookAuthor, yearOfPublication, publisher);
    }
}
