package com.experis;

public class FindInMatrix {

    public void find(int[][] mat, int x) {
        if (mat == null) {
            return;
        }

        int row = mat.length;
        int column = mat[0].length;

        int i = 0, j = column - 1;

        while (i < row && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("i=" + i + "  j=" + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else
                i++;
        }

        System.out.print("Not found");
    }
}
