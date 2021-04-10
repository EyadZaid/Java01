package training.expires.logic.inputs;

import training.expires.data.Book;
import training.expires.logic.IllegalDataFormatException;

public interface IDataFormat {

    Book inputParse(String line) throws IllegalDataFormatException;
}
