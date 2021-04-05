package training.expires.inputs;

import training.expires.dao.Book;

public interface IDataFormat {

    Book inputParse(String line);
}
