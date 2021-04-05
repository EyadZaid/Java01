package training.expires.dao;

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
        if (length != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = isbn.charAt(i) - '0';
            if (0 > digit || 9 < digit) {
                return false;
            }
            sum += (digit * (10 - i));
        }

        char last = isbn.charAt(9);
        if (last != 'X' && (last < '0' || last > '9')) {
            return false;
        }
        sum += ((last == 'X') ? 10 : (last - '0'));
        return (sum % 11 == 0);
    }
}