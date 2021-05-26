package com.experis;
/**
 * Write a function to check if a number is a power of 8.   give 2 different efficient solutions.
 */
public class NumPowerOfEight {

    public static boolean checkNumPowerOf8(int number) {
        int pow = 1;
        while (pow < number) {
            pow = pow * 8;
        }

        return pow == number;
    }

    public static boolean checkNumPowerOfEight(int number) {
        double res = Math.log(number) / Math.log(8);

        return (res - Math.floor(res) < 0.000001);
    }

}
