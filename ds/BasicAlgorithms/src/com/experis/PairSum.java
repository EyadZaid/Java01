package com.experis;

import java.util.HashSet;

public class PairSum {
    public static void pairEqualSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int num;
        for (int i = 0; i < arr.length; ++i) {
            num = sum - arr[i];

            if (set.contains(num)) {
                System.out.println("(" + arr[i] + ", " + num + ")");
            }
            set.add(arr[i]);
        }
    }
}
