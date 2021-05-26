package com.experis;

public class CountsPairsBits {

    /**
     * given an unsigned long (64 bits) write a function that counts the number of pairs of 1's :
     * i.e. : 00011001110101 has 3 pairs of 1
     */

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


    public static int countsPairsBits2(long n) {
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }

        return count/2;
    }


    /**
     * Same as previous but we count pairs of 1s (2 consecutive bits that are 1 make one pair).
     * i.e. : 00101101110  has 3 pairs
     */

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
