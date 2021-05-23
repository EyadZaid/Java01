package com.experis;

import java.util.Iterator;
import java.util.LinkedList;

public class DeleteAllDuplicate<T> {

    public static <T extends Comparable<? super T>> void deleteDuplicate(LinkedList<T> list) {
        LinkedList<T> result = new LinkedList<T>();
        Iterator<T> itr = list.iterator();
        while(itr.hasNext()) {
            T currentTest = itr.next();
            if (!result.contains(currentTest)) {
                result.add(currentTest);
            }
            else {
                itr.remove();
            }
        }
    }
}