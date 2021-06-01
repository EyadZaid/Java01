package com.experis;

public class PreviousPowerOf2 {

    public static int prevPowOf2(int n) {
        return 1 << log(n, 2);  // 1 << num  == 2^num
    }

    private static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
}
