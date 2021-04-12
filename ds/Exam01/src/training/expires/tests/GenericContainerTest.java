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


}