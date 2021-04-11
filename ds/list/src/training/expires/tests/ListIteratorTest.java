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
    private DoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    @Test
    void listIteratorTest(){
        var givenList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = new ArrayList<>();

        for (var item : givenList){
            linkedList.addAtTail(item);
        }

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            resultList.add(iterator.next());
        }

        assertEquals(givenList.size(), resultList.size());

        for (int i=0; i<givenList.size(); i++){
            assertEquals(givenList.get(i), resultList.get(i));
        }
    }

    @Test
    void emptyListIteratorTest(){
        Iterator<Integer> iterator = linkedList.iterator();
        assertFalse(iterator.hasNext());
    }
}