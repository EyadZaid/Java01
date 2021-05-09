package tests;

import org.junit.jupiter.api.Test;
import training.expires.BigNumber;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {

    @Test
    void bigNumberTest() {
        BigNumber number1 = new BigNumber("1234321");
        BigNumber number2 = new BigNumber("100");

        BigNumber result = BigNumber.add(number1, number2);
        String expected = "1234421";
        assertEquals(expected, result.convertToString());

        /*
        BigNumber result = BigNumber.multiple(number1, number2);
        String expected = "123432100";
        assertEquals(expected, result.convertToString());

        result = BigNumber.add(number1, number2);
        expected = "1234421";
        assertEquals(expected, result.convertToString());

        result = BigNumber.absoluteNumber(number1);
        expected = "1234321";
        assertEquals(expected, result.convertToString());

        boolean isPalindrome = BigNumber.checkPalindrome(number1);
        assertTrue(isPalindrome);

         */
    }
}