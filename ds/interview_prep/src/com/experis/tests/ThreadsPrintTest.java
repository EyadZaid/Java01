package com.experis.tests;

import com.experis.ThreadsPrint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsPrintTest {

    @Test
    public void testThreadsPrint() {
        ThreadsPrint threadsPrint = new ThreadsPrint(10_000);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                threadsPrint.printEvenNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                threadsPrint.printOddNumber();
            }
        });

        t1.start();
        t2.start();
    }

}