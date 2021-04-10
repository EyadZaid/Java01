package training.expires.data;

import java.util.Objects;

public class Isbn {
    private String isbn;

    public Isbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn1 = (Isbn) o;
        return Objects.equals(isbn, isbn1.isbn);
    }

    @Override
    public String toString() {
        return isbn;
    }

    public boolean checkValidIsbn() {
        int length = isbn.length();
        if (length >= 8 && length <= 10) {
            return true;
        }
        return false;
    }
}