package training.expires;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Person, Integer> binarySearchTree;
    IKeyExtractor<Person, Integer> keyExtractor;

    @BeforeEach
    void setup(){
        keyExtractor = new KeyExtractorImpl<>();
        binarySearchTree = new BinarySearchTree<>(keyExtractor, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
    }

    void insrtElemnts(){
        Person p1 = new Person("Person 5", 5);
        Person p2 = new Person("Person 2", 2);
        Person p3 = new Person("Person 8", 8);
        Person p4 = new Person("Person 3", 3);

        keyExtractor.addItem(p1,p1.getId());
        keyExtractor.addItem(p2,p2.getId());
        keyExtractor.addItem(p3,p3.getId());
        keyExtractor.addItem(p4,p4.getId());

        binarySearchTree.insert(p1);
        binarySearchTree.insert(p2);
        binarySearchTree.insert(p3);
        binarySearchTree.insert(p4);
    }

    @org.junit.jupiter.api.Test
    void insert(){
        insrtElemnts();
        assertEquals(4, binarySearchTree.size());
    }

    @org.junit.jupiter.api.Test
    void find(){
        insrtElemnts();
        Person p = new Person("Person 10", 10);
        keyExtractor.addItem(p,p.getId());
        binarySearchTree.insert(p);
        assertEquals(p, binarySearchTree.find(10));
    }

    @org.junit.jupiter.api.Test
    void contains(){
        insrtElemnts();
        Person p = new Person("Person 10", 10);
        keyExtractor.addItem(p,p.getId());
        binarySearchTree.insert(p);

        assertTrue(binarySearchTree.contains(p));
    }

    @org.junit.jupiter.api.Test
    void isEmpty(){
        insrtElemnts();
        assertFalse(binarySearchTree.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size(){
        insrtElemnts();
        assertEquals(4, binarySearchTree.size());
    }

    @org.junit.jupiter.api.Test
    void max(){
        insrtElemnts();
        Person p = new Person("Person 10", 10);
        keyExtractor.addItem(p,p.getId());
        binarySearchTree.insert(p);
        assertEquals(p, binarySearchTree.max());
    }

    @org.junit.jupiter.api.Test
    void min(){
        insrtElemnts();
        Person p = new Person("Person 1", 1);
        keyExtractor.addItem(p,p.getId());
        binarySearchTree.insert(p);
        assertEquals(p, binarySearchTree.min());
    }

    @org.junit.jupiter.api.Test
    void max_nth(){
        insrtElemnts();
        Person p = new Person("Person 100", 100);
        keyExtractor.addItem(p,p.getId());
        binarySearchTree.insert(p);
        assertEquals(p, binarySearchTree.max_nth(5));
    }

    @org.junit.jupiter.api.Test
    void height(){
        insrtElemnts();
        assertEquals(3, binarySearchTree.height());
    }

    @org.junit.jupiter.api.Test
    void isPerfect(){
        Person p1 = new Person("Person 5", 5);
        Person p2 = new Person("Person 2", 2);
        Person p3 = new Person("Person 8", 8);
        keyExtractor.addItem(p1,p1.getId());
        keyExtractor.addItem(p2,p2.getId());
        keyExtractor.addItem(p3,p3.getId());
        binarySearchTree.insert(p1);
        binarySearchTree.insert(p2);
        binarySearchTree.insert(p3);

        assertTrue(binarySearchTree.isPerfect());
    }

    @org.junit.jupiter.api.Test
    void isComplete(){
        Person p1 = new Person("Person 5", 5);
        Person p2 = new Person("Person 2", 2);
        Person p3 = new Person("Person 8", 8);
        keyExtractor.addItem(p1,p1.getId());
        keyExtractor.addItem(p2,p2.getId());
        keyExtractor.addItem(p3,p3.getId());
        binarySearchTree.insert(p1);
        binarySearchTree.insert(p2);
        binarySearchTree.insert(p3);

        assertTrue(binarySearchTree.isComplete());
    }


    @org.junit.jupiter.api.Test
    void removeByKey(){
        insrtElemnts();
        binarySearchTree.remove(5);
        int size =binarySearchTree.size();
        assertEquals(3, binarySearchTree.size());
    }

}