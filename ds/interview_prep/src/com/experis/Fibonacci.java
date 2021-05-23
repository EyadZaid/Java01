package com.experis;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static final Map<Integer, Long> map = new HashMap<>();

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (n < 0) {
            throw new IllegalArgumentException("The number most be a positive");
        }

        var res = map.get(n);
        if (res == null) {
            res = fibonacci(n - 1) + fibonacci(n-2);
            map.put(n, res);
        }
        return res;
    }

}
