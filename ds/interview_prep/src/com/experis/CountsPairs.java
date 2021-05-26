package com.experis;

public class CountsPairs {

    public static int countsPairsBits(long n) {
        int result = 0;
        int pair = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (pair == 1) {
                    result++;
                    pair = 0;
                }
                else {
                    pair++;
                }
            }
            n >>= 1;
        }

        return result;
    }

}
