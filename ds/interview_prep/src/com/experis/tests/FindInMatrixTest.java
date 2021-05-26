package com.experis.tests;

import com.experis.FindInMatrix;
import com.experis.PairNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindInMatrixTest {

    @Test
    public void testFindInMatrix() {
        FindInMatrix findInMatrix = new FindInMatrix();

        int mat[][] = {
                { 13, 22, 31, 44 },
                { 18, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 } };

        PairNumbers pair = findInMatrix.find(mat, 48);

        assertEquals(pair.getX(), 2);
        assertEquals(pair.getY(), 3);
    }


}