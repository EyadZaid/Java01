package com.experis;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsPrint {
    private int number = 0;
    private final int size;

    private final Lock lock;
    private final Condition oddNumber;
    private final Condition evenNumber;

    public ThreadsPrint(int size) {
        this.size =size;
        lock = new ReentrantLock();
        oddNumber = lock.newCondition();
        evenNumber = lock.newCondition();
    }

    public void printEvenNumber() {
        lock.lock();
        try {
            while (number < size) {
                while (number % 2 == 1) {
                    evenNumber.await();
                }
                System.out.print(number + " ");
                number++;

                oddNumber.signal();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }


    public void printOddNumber() {
        lock.lock();
        try {
            while (number < size) {
                while (number % 2 == 0) {
                    oddNumber.await();
                }
                System.out.print(number + " ");
                number++;

                evenNumber.signal();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
