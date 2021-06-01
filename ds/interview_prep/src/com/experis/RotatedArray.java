package com.experis;

public class RotatedArray {
    public void rightRotate(int[] arr, int rot) {
        int size = arr.length;
        while (size < rot){
            rot = rot % arr.length;
        }

        int[] temp = new int[size - rot];

        for (int i = 0; i < size - rot; i++) {
            temp[i] = arr[i];
        }

        for (int i = size - rot; i < size; i++) {
            arr[i - rot - 1] = arr[i];
        }

        for (int i = 0; i < size - rot; i++) {
            arr[i + rot] = temp[i];
        }
    }


    public static int amountRotations(int[] arr) {
        assert arr != null;

        if (arr.length > 0 && arr[0] <= arr[arr.length-1]) {
            return 0;
        }

        int min = arr[0], indexMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                indexMin = i;
            }
        }
        return indexMin;
    }


    public static void rotateMatrix(int[][] arr) {
        int size = arr.length, temp;
        for (int i=0; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (i != j) {
                    temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }

        for (int i=0; i<size; i++) {
            for (int j=0; j<size/2; j++) {
                if (i != j) {
                    temp = arr[i][j];
                    arr[i][j] = arr[i][size - j - 1];
                    arr[i][size - j - 1] = temp;
                }
            }
        }
    }
}
