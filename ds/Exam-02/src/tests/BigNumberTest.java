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

        result = BigNumber.absoluteNumber(number1);
        expected = "1234421";
        assertEquals(expected, result.convertToString());


        expected = "1234321";
        assertEquals(expected, number1.convertToString());

        /*
        boolean isPalindrome = BigNumber.checkPalindrome(number1);
        assertTrue(isPalindrome);
*/
    }
}