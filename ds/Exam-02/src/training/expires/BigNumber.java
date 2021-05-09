package training.expires;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BigNumber {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Node head;
    private boolean isPositive;

    public BigNumber(String digits) {
        head = convertToLinkedList(digits);
    }

    public BigNumber(Node node) {
        head = node;
    }

    private Node convertToLinkedList(String digits) {
        Node res = null;

        if (digits.length() < 1) {
            return null;
        }

        char firstChar = digits.charAt(0);
        if (firstChar == '-') {
            isPositive = false;
        }
        else {
            isPositive = true;
        }

        if (firstChar >= '0' && firstChar <= '9') {
            res = new Node(firstChar - '0');
        }

        for (int i=1; i<digits.length(); i++) {
            Node new_node = new Node(digits.charAt(i) - '0');
            new_node.next = res;
            res = new_node;
        }

        return reverse(res);
    }

    public static BigNumber add(BigNumber num1, BigNumber num2) {
        Node nodeN1 = num1.head;
        Node nodeN2 = num2.head;
        if (nodeN2 == null) {
            return num1;
        }

        if (nodeN1 == null) {
            return num2;
        }

        nodeN1 = reverse(nodeN1);
        nodeN2 = reverse(nodeN2);

        Node head = nodeN1;
        Node prev = null;
        int sum, carry =0;

        while(nodeN1 != null && nodeN2 != null) {
            sum = carry + nodeN1.data + nodeN2.data;
            nodeN1.data = sum % 10;
            carry = sum / 10;
            prev = nodeN1;
            nodeN1 = nodeN1.next;
            nodeN2 = nodeN2.next;
        }

        if(nodeN1 != null || nodeN2 != null) {
            if(nodeN2 != null) {
                prev.next = nodeN2;
            }
            nodeN1 = prev.next;
            while(nodeN1 != null) {
                sum = carry + nodeN1.data;
                nodeN1.data = sum % 10;
                carry = sum / 10;
                prev = nodeN1;
                nodeN1 = nodeN1.next;
            }
        }
        if(carry > 0) {
            prev.next = new Node(carry);
        }

        return  new BigNumber(reverse(head));
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while(current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
        return head;
    }

    public String convertToString() {
        StringBuilder str = new StringBuilder();
        Node h = head;

        while(h != null) {
            str.append(h.data);
            h = h.next;
        }

        return str.toString();
    }










    public void traverse(BigNumber number)
    {
        Node h = number.head;
        while(h != null)
        {
            System.out.print(h.data + "->");
            h = h.next;
        }
    }




    /*
    private List<Integer> list;
    private char sign;

    public BigNumber(String digits) {
        list = convertToList(digits);
    }

    private List<Integer> convertToList(String digits) {
        List<Integer> result = new ArrayList<>();
        /*
        if (digits.length() > 0 && !(digits.charAt(0) >= '0' && digits.charAt(0) <= '9')) {
            if (digits.charAt(0) == '-') {
                sign = '-';
            }
            else {
                sign = '+';
            }
        }
        else {
            result.add(digits.charAt(0) - '0');
        }
         */
/*
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

    public static BigNumber absoluteNumber(BigNumber bigNumber) {
        bigNumber.sign = '+';
        return bigNumber;
    }

    public static boolean checkPalindrome(BigNumber number) {
        return checkPalindrome(number.convertToString());
    }

    private static boolean checkPalindrome(String str) {
        if(str.length() == 0 || str.length() == 1) {
            return true;
        }
        if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return checkPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }

    @Override
    public String toString() {
        return "BigNumber{" +
                "list=" + list +
                '}';
    }

 */
}
