package com.experis;

import java.util.Collections;
import java.util.LinkedList;

public class DeleteAllDuplicate<T> {

    public static <T extends Comparable<? super T>> void deleteDuplicate(LinkedList<T> list) {
        for (int i=0; i<list.size(); i++) {
            T currentItem = list.get(i);
            list.remove(currentItem);
            if (list.contains(currentItem)) {
                list.removeAll(Collections.singleton(currentItem));
            }
            else {
                list.add(currentItem);
            }
        }
    }
}