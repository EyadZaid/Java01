package com.experis.tests;

import com.experis.ThreadsPrint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadsPrintTest {

    @Test
    public void testThreadsPrint() {
        ThreadsPrint threadsPrint = new ThreadsPrint(10_000);

        Thread e = new Thread(new Runnable() {
            public void run() {
                threadsPrint.printEvenNumber();
            }
        });

        Thread o = new Thread(new Runnable() {
            public void run() {
                threadsPrint.printOddNumber();
            }
        });

        e.start();
        o.start();
    }

}