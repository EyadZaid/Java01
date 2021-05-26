package com.experis;

public class FindInMatrix {

    public PairNumbers find(int[][] mat, int x) {
        if (mat == null) {
            return null;
        }

        int row = mat.length;
        int column = mat[0].length;

        int i = 0, j = column - 1;

        while (i < row && j >= 0) {
            if (mat[i][j] == x) {
                return new PairNumbers(i, j);
            }
            if (mat[i][j] > x)
                j--;
            else
                i++;
        }

        return new PairNumbers(-1, -1);
    }
}
