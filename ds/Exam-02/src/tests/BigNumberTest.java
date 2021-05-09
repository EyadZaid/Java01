package tests;

import org.junit.jupiter.api.Test;
import training.expires.BigNumber;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {

    @Test
    void addTest() {
        BigNumber number1 = new BigNumber("1234321");
        BigNumber number2 = new BigNumber("100");

        BigNumber result = BigNumber.add(number1, number2);
        String expected = "1234421";
        assertEquals(expected, result.convertToString());
    }

    @Test
    void mulTest() {
        BigNumber number1 = new BigNumber("1234321");
        BigNumber number2 = new BigNumber("100");

        BigNumber result = BigNumber.multiply(number1, number2);
        String expected = "123432100";
        assertEquals(expected, result.convertToString());
    }

    @Test
    void isPalindromeTest() {
        BigNumber number1 = new BigNumber("1234321");

        boolean isPalindrome = BigNumber.checkPalindrome(number1);
        assertTrue(isPalindrome);
    }


    @Test
    void absoluteNumberTest() {
        BigNumber number1 = new BigNumber("1234321");

        BigNumber result = BigNumber.absoluteNumber(number1);
        String expected = "1234321";
        assertEquals(expected, result.convertToString());
    }


}