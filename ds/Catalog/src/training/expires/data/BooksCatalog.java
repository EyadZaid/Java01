package training.expires.data;

import training.expires.inputs.FileRead;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class BooksCatalog {
    private HashSet<Book> allBooks;
    private FileRead fileRead;


    public BooksCatalog() throws FileNotFoundException {
        this.allBooks = new HashSet<>();;
        this.fileRead = new FileRead("books-small.txt");
    }

    public boolean addBook(Book book){
        return allBooks.add(book);
    }

    public int amountOfBooks(){
        return allBooks.size();
    }

    public HashSet<Book> getAllBooks() {
        return allBooks;
    }

    private Book inputParser(String line){

        String[] details = line.split("\\|");
        if (details.length != 5){
            return null;
        }
        String isbn = details[0];
        String bookTitle = details[1];
        String bookAuthor = details[2];
        int yearOfPublication = Integer.parseInt(details[3]);
        String publisher = details[4];
        return new Book(isbn, bookTitle, bookAuthor, yearOfPublication, publisher);
    }


    public void addAllBooks(){
        String line;
        Book book;
        Boolean isFirstLine = true;

        fileRead.readline();
        if (fileRead.isEnd()){
            return;
        }
        line = fileRead.readline();
        while (!fileRead.isEnd()){
            book = inputParser(line);
            allBooks.add(book);
            line = fileRead.readline();
        }
        fileRead.close();
    }


    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
