package training.expires.inputs;

import training.expires.data.Book;

public interface IDataFormat {

    Book inputParse(String line);
}
