package com.experis;

public class MissingNumber {

    static int missingNum(int arr[]) {
        int n = arr.length + 1;
        int itemsSum = n * (n + 1) / 2;
        int sum = 0;

        for(int i = 0; i < n - 1; i++) {
            sum += arr[i];
        }

        return itemsSum - sum;
    }
}
