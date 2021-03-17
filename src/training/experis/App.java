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
    }


    public static void bubbleSort(int[] v) {
        if (v == null) {
            System.out.println("Exception: Array is null");
        }
        int len = v.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len - i); j++) {
                if (v[j - 1] > v[j]) {
                    int temp = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = temp;
                }
            }
        }
    }


    public static void shakeArray(int[] v) {
        if (v == null) {
            System.out.println("Exception: Array is null");
        }
        Random rnd = new Random();
        for (int i = 0; i < v.length; i++) {
            int rand_index = rnd.nextInt(v.length);
            int temp = v[rand_index];
            v[rand_index] = v[i];
            v[i] = temp;
        }
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

        int lenArr1 = array1.length;
        int partIndex = array1.length - array2.length;
        int j=0;

        //copy all elements from array 2 to last array 1
        for (int i=partIndex; i<array1.length; i++){
            array1[i] = array2[j++];
        }

        int newArray[] = new int[lenArr1];
        int indexArr1=0, indexPart2=partIndex, indexNewArr=0;
        while (indexArr1<partIndex && indexPart2 <lenArr1) {
            if (array1[indexArr1] < array1[indexPart2]) {
                newArray[indexNewArr++] = array1[indexArr1++];
            }
            else
                newArray[indexNewArr++] = array1[indexPart2++];
        }

        while (indexArr1 < partIndex) {
            newArray[indexNewArr++] = array1[indexArr1++];
        }

        while (indexPart2 < lenArr1) {
            newArray[indexNewArr++] = array1[indexPart2++];
        }

        for (int i=0; i<array1.length; i++){
            array1[i] = newArray[i];
        }
    }


    public static void testMergeImportantElements(){
        int[] v1 = {10, 25, 6, 3, -2};
        int[] v2 = {0, 1, 2, 7, 8, 9, 9, 10, 12, 15, 20};
        int[] v3 = {3, 7, 8, 12, 19};
        int[] v4 = {0, 1, 2, 4, 5, 7, 9, 10, 12, 15, 20};
        int[] v5 = {2, 5, 16, 18, 22};

        mergeImportantElements(v4, v5);
        print(v4);
    }

    public static void testPolynomial(){
        Polynomial polynom = new Polynomial();
        double[] p1 = {4, 5, -3};
        double[] p2 = {2, 0, -3};
        double[] p3 = {2};

        polynom.printPolynom(p1);
        polynom.printPolynom(p2);
        polynom.printPolynom(p3);

        System.out.println("Result: " + polynom.calculatePolynom(3, p1));
        System.out.println("Result: " + polynom.calculatePolynom(2, p2));
        System.out.println("Result: " + polynom.calculatePolynom(1, p3));
    }


    public static void main(String[] args) {
        System.out.println("Test Merge Important Elements: ");
        testMergeImportantElements();
        System.out.println("\n\nTest Polynomial: ");
        testPolynomial();
    }
}
