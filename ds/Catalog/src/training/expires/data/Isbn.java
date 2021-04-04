package training.expires.data;

public class Isbn {

    public boolean checkValidIsbn(String isbn) {
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