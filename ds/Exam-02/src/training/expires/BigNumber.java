package training.expires;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static BigNumber multiple(BigNumber number1, BigNumber number2) {
        BigNumber bigNumber = new BigNumber("");
        int len1 = number1.list.size();
        int len2 = number2.list.size();
        if (len1 == 0 || len2 == 0) {
            bigNumber.list.add(0);
            return bigNumber;
        }

        int result[] = new int[len1 + len2];
        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = number1.list.get(i);
            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = number2.list.get(j);
                int sum = n1 * n2 + result[i_n1+i_n2] + carry;
                carry = sum / 10;
                result[i_n1 + i_n2] = sum % 10;
                i_n2++;
            }

            if (carry > 0) {
                result[i_n1 + i_n2] += carry;
            }
            i_n1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }

        if (i == -1) {
            bigNumber.list.add(0);
            return bigNumber;
        }

        while (i >= 0) {
            bigNumber.list.add(result[i--]);
        }
        return bigNumber;
    }

    @Override
    public String toString() {
        return "BigNumber{" +
                "list=" + list +
                '}';
    }
}
