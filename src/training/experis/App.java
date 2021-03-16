package training.experis;

import java.util.Random;

public class App {

    public static void print(int[] v){
        if (v == null) {
            System.out.println("Exception: Array is null");
        }
        System.out.printf("%c",'[');
        for (int i=0; i<v.length; i++){
            System.out.printf("%d", v[i]);
            if ( i != v.length - 1){
                System.out.printf("%c",',');
            }
        }
        System.out.printf("%c",']');
    }


    public static void print(int[][] m){
        if (m == null) {
            System.out.println("Exception: Matrix is null");
        }
        System.out.printf("%c",'[');
        for (int i=0; i<m.length; i++){
            print(m[i]);
            if ( i != m.length - 1){
                System.out.printf("%c",',');
            }
        }
        System.out.printf("%c",']');
    }


    public static void makeArray(int len, int start, int step){
        int num = 1;
        int[] v = new int[len];
        for (int i=0; i<len; i++){
            v[i] = start + step * num++;
        }
        print(v);
    }


    public static void bubbleSort(int[] v) {
        if (v == null) {
            System.out.println("Exception: Array is null");
        }
        int temp, len = v.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len - i); j++) {
                if (v[j - 1] > v[j]) {
                    temp = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = temp;
                }
            }
        }
        print(v);
    }


    public static void shakeArray(int[] v) {
        if (v == null) {
            System.out.println("Exception: Array is null");
        }
        for (int i = 0; i < v.length; i++)
        {
            int rand_index = new Random().nextInt(v.length);
            int temp = v[rand_index];
            v[rand_index] = v[i];
            v[i] = temp;
        }
        print(v);
    }


    public static void initMagicSquare(int[][] m){
        if (m == null) {
            System.out.println("Exception: Matrix is null");
        }
        int len = m.length;
        int row_num = len-1;
        int col_num = len/2;
        m[row_num][col_num] = 1;

        for (int i = 2; i <= len*len; i++) {
            if (m[(row_num + 1) % len][(col_num + 1) % len] == 0) {
                row_num = (row_num + 1) % len;
                col_num = (col_num + 1) % len;
            } else {
                row_num = (row_num - 1 + len) % len;
            }
            m[row_num][col_num] = i;
        }
        print(m);
    }


    public static void makeMatrix(int m, int n){
        if (m <= 0 & n <= 0){
            System.out.println("Exception: Invalid input");
        }
        int[][] matrix = new int[m][n];
        int i=0, j=0, num=1, c=0, k=0;
        while (i<m && j<n){
            k = i;
            while ((k+j) == c){
                matrix[k][j] = num++;
                if (k>0){
                    k--;
                }
                else
                    break;
                if (j<n){
                    j++;
                }
                else
                    break;
            }
            c++;
            i++;
            j=0;
        }
        print(matrix);
    }

    public static void mergeImportantElements(int[] array1, int[] array2){
        if (array1 == null ) {
            System.out.println("Exception: First array is null");
        }

        if (array2 == null ) {
            System.out.println("Exception: second array is null");
        }

        if (array1 == array2){
            return;
        }

        if (array2.length == 0){
            return;
        }

        int lenArr1 = array1.length - array2.length;
        int lenArr2 = array2.length;
        int newArray[] = new int[lenArr1+lenArr2];
        int indexArr1, indexArr2, indexNewArr;
        indexNewArr = indexArr1 = indexArr2 = 0;
        while (indexArr1<lenArr1 && indexArr2 <lenArr2) {
            if (array1[indexArr1] < array2[indexArr2]) {
                newArray[indexNewArr++] = array1[indexArr1++];
            }
            else
                newArray[indexNewArr++] = array2[indexArr2++];
        }

        while (indexArr1 < lenArr1) {
            newArray[indexNewArr++] = array1[indexArr1++];
        }

        while (indexArr2 < lenArr2) {
            newArray[indexNewArr++] = array2[indexArr2++];
        }
        print(newArray);
    }

    public static void testCode(){
        int[] v1 = {10, 25, 6, 3, -2};
        int[] v2 = {0, 1, 2, 7, 8, 9, 9, 10, 12, 15, 20};
        int[] v3 = {3, 7, 8, 12, 19};
        int[] v4 = {0, 1, 2, 4, 5, 7, 9, 10, 12, 15, 20};
        int[] v5 = {3, 7, 11, 12, 19};
        int[][] m1 = {
                {3, 1, 6, 3, 88},
                {10, 25, 62, 15, -2}
        };
        int[][] m2 = new int[3][3];

        System.out.println("\nMake array by steps:");
        makeArray(8, -2, 3);
        System.out.println("\nBubble sort:");
        bubbleSort(v1);
        System.out.println("\nShake array:");
        shakeArray(v1);
        System.out.println("\nMerge important elements: ");
        mergeImportantElements(v4, v5);
        System.out.println("\nMagic square: ");
        initMagicSquare(m2);
        System.out.println("Make a matrix: ");
        makeMatrix(3,3);
    }


    public static void main(String[] args) {
        testCode();
    }
}
