package training.expires.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import training.expires.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ListIteratorTest {
    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void listIteratorTest(){
        var givenList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = new ArrayList<>();

        for (int i=0; i<givenList.size(); i++){

        }

        for (var item : givenList){
            list.addAtTail(item);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            resultList.add(iterator.next());
        }

        assertEquals(givenList.size(), resultList.size());

        for (int i=0; i<givenList.size(); i++){
            assertEquals(givenList.get(i), resultList.get(i));
        }
    }
}