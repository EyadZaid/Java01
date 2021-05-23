package com.experis.tests;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static com.experis.DeleteAllDuplicate.deleteDuplicate;
import static org.junit.jupiter.api.Assertions.*;

class DeleteAllDuplicateTest {

    @Test
    public void testDeleteAllDuplicate() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(11);
        list.add(13);
        list.add(14);
        list.add(14);
        list.add(10);
        list.add(10);

        System.out.println(list);

        deleteDuplicate(list);

        System.out.println(list);
    }

}