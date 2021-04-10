package training.expires.data;

import java.util.Objects;

public class Book {
    private Isbn isbn;
    private String bookTitle;
    private String bookAuthor;
    private int yearOfPublication;
    private String publisher;

    public Book(Isbn isbn, String bookTitle, String bookAuthor, int yearOfPublication, String publisher) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    public String display(){
        StringBuilder str = new StringBuilder();
        str.append(isbn + "|");
        str.append(bookTitle + "|");
        str.append(bookAuthor + "|");
        str.append(yearOfPublication + "|");
        str.append(publisher);
        return str.toString();
    }

    public String displayByLines(){
        StringBuilder str = new StringBuilder();
        str.append("ISBN:\t" + isbn + "\n");
        str.append("Title:\t" + bookTitle + "\n");
        str.append("Author:\t" + bookAuthor + "\n");
        str.append("Year:\t" + yearOfPublication + "\n");
        str.append("Publisher:\t" + publisher + "\n");
        return str.toString();
    }
}
