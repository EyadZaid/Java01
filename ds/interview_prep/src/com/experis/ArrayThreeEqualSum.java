package com.experis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayThreeEqualSum {



    public static boolean isSplitToThree(int[] arr) {
        assert arr != null;
        if (arr.length < 3) {
            return false;
        }

        int sumArr = 0, groupSum;
        for (var i : arr) {
            sumArr += i;
        }
        if (sumArr % 3 != 0) {
            return false;
        }
        else {
            groupSum = sumArr / 3;
        }

        return false;

    }



    private boolean isExistGroupEqualSam(int[] arr, int expectedSum) {
        List<Integer> list = new ArrayList<>();
        int sum = 0, i = 0;
        while (true){
            if (arr[i] == -1) {
                i = (i + 1) % arr.length;
                continue;
            }

            if (sum == expectedSum) {
                return true;
            }


            if (sum > expectedSum) {
                int num = list.remove(0);
                addNumToArray(arr, num);
                continue;
            }

            sum += arr[i];
            list.add(arr[i]);
            arr[i] = -1;
            i = (i + 1) % arr.length;
        }
    }

    private void addNumToArray(int[] arr, int num) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == -1) {
                arr[i] = num;
                return;
            }
        }
    }


    private boolean subArraySum(int[] arr, int sum) {
        int n = arr.length;
        int currentSum = arr[0], start = 0, i;

        for (i = 1; i <= n; i++) {
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            if (currentSum == sum) {
                return true;
            }

            if (i < n)
                currentSum = currentSum + arr[i];
        }
        return false;
    }
}
