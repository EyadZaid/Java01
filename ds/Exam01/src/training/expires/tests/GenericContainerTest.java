package training.expires.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.expires.GenericContainer;

import static org.junit.jupiter.api.Assertions.*;

class GenericContainerTest {
    private GenericContainer<Integer> container;

    @BeforeEach
    void setUp() {
        container = new GenericContainer<>();
    }

    @Test
    void pushAndPopTest(){
        container.push(13);
        container.push(8);
        container.push(-2);
        container.push(6);

        assertEquals(6, container.pop());
        assertEquals(-2, container.pop());
        assertEquals(8, container.pop());
        assertEquals(13, container.pop());
        assertEquals(null, container.pop());
    }


    @Test
    void getMinTest(){
        container.push(13);
        container.push(8);
        container.push(-2);
        container.push(6);

        assertEquals(-2, container.min());
        assertEquals(6, container.pop());
        assertEquals(-2, container.pop());
        assertEquals(8, container.min());
        assertEquals(8, container.pop());
        assertEquals(13, container.min());
    }

    @Test
    void iteratorTest(){
        int array[] = {6, -2, 8, 13};

        for (var e : array){
            container.push(e);
        }

        int index = 0;
        for (var v : container){
            assertEquals(array[index++], v);
        }
    }


}