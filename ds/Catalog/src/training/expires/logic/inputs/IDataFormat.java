package training.expires.logic.inputs;

import training.expires.dao.Book;
import training.expires.logic.IllegalDataFormatException;

public interface IDataFormat {

    Book inputParse(String line) throws IllegalDataFormatException;
}
