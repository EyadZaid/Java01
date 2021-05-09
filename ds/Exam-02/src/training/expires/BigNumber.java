package training.expires;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BigNumber {
    private List<Integer> list;

    public BigNumber(String digits) {
        list = convertToList(digits);
    }

    private List<Integer> convertToList(String digits) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<digits.length(); i++) {
            result.add(digits.charAt(i) - '0');
        }
        return result;
    }

    public String convertToString() {
        return convertToString(list);
    }

    private static String convertToString(List<Integer> numbers) {
        StringBuilder str = new StringBuilder();
        for (var e : numbers) {
            str.append(e);
        }
        return str.toString();
    }

    public static BigNumber add(BigNumber number1, BigNumber number2) {
        if (number1.list.size() > number2.list.size()){
            BigNumber t = number1;
            number1 = number2;
            number2 = t;
        }

        List<Integer> result = new ArrayList<>();

        int n1 = number1.list.size(), n2 = number2.list.size();
        int diff = n2 - n1;
        int carry = 0;

        for (int i = n1 - 1; i>=0; i--) {
            int sum = number1.list.get(i) + number2.list.get(i+diff) + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        for (int i = n2 - n1 - 1; i >= 0; i--) {
            int sum = number2.list.get(i) + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            result.add(carry);
        }

        Collections.reverse(result);
        BigNumber bigNumber = new BigNumber(convertToString(result));
        return bigNumber;
    }

    @Override
    public String toString() {
        return "BigNumber{" +
                "list=" + list +
                '}';
    }
}
