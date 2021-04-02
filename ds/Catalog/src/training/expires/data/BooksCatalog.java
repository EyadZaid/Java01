package training.expires.data;

import java.util.HashSet;

public class BooksCatalog {
    private HashSet<Book> allBooks;


    public BooksCatalog() {
        this.allBooks = new HashSet<>();;
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

    @Override
    public String toString() {
        return "BooksCatalog{" +
                "allBooks=" + allBooks +
                '}';
    }
}
