package training.expires.data;

public class Book {
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private int yearOfPublication;
    private String publisher;

    public Book(String isbn, String bookTitle, String bookAuthor, int yearOfPublication, String publisher) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
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
}
