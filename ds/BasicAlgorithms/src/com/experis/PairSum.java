package com.experis;

import java.util.Arrays;
import java.util.HashSet;

public class PairSum {
    public static void pairEqualSum(int[] arr, int sum) {
        assert arr != null;
        int num;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; ++i) {
            num = sum - arr[i];

            if (set.contains(num)) {
                System.out.println("(" + arr[i] + ", " + num + ")");
            }
            set.add(arr[i]);
        }
    }


    public static void pairEqualSumWithSort(int[] arr, int sum) {
        int i, j;

        Arrays.sort(arr);
        i = 0;
        j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                System.out.println("(" + arr[j] + ", " + arr[i] + ")");
                i++;
            }
            else {
                if (arr[i] + arr[j] < sum) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }
    }
}
