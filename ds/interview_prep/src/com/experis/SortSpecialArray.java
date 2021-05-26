package com.experis;

public class SortSpecialArray {

    public static void sortArr(int arr[]) {
        assert arr != null;
        int i, count0 = 0, count1 = 0, count2 = 0;

        for (i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }

        i = 0;
        while (count0 > 0) {
            arr[i++] = 0;
            count0--;
        }

        while (count1 > 0) {
            arr[i++] = 1;
            count1--;
        }

        while (count2 > 0) {
            arr[i++] = 2;
            count2--;
        }
    }

}
