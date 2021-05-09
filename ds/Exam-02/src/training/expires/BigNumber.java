package training.expires;

import java.util.ArrayList;
import java.util.Arrays;
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

    public String convertToString() {
        StringBuilder str = new StringBuilder();
        Node h = head;

        while(h != null) {
            str.append(h.data);
            h = h.next;
        }

        return str.toString();
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

    public static BigNumber multiply(BigNumber num1, BigNumber num2) {
        String str1 = num1.convertToString();
        String str2 = num2.convertToString();
        String res = multiply(str1, str2);
        return new BigNumber(res);
    }

    private static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }

        int result[] = new int[len1 + len2];
        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
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
            return "0";
        }

        String s = "";
        while (i >= 0) {
            s += (result[i--]);
        }

        return s;
    }

    public static BigNumber absoluteNumber(BigNumber bigNumber) {
        bigNumber.isPositive = true;
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

}
