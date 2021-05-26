package com.experis.tests;

import com.experis.FindInMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindInMatrixTest {

    @Test
    public void testFindInMatrix() {
        FindInMatrix findInMatrix = new FindInMatrix();

        int mat[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        findInMatrix.find(mat, 29);
    }


}