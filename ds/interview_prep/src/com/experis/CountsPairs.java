package com.experis;

public class CountsPairs {

    public static int countsPairsBits(long n) {
        int result = 0;
        int pair = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (pair == 2) {
                    result++;
                    pair = 1;
                }
                else {
                    pair++;
                }
            }
            n >>= 1;
        }

        return result;
    }



    public static int countsPairsBitsConsecutive (long n) {
        int result = 0;
        int pair = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (pair == 2) {
                    result++;
                    pair = 1;
                }
                else {
                    pair++;
                }
            }
            else {
                pair = 1;
            }
            n >>= 1;
        }

        return result;
    }
}
