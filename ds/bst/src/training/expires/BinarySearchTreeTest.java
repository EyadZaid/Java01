package training.expires;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

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

        try {
            binarySearchTree.insert(p1);
            binarySearchTree.insert(p2);
            binarySearchTree.insert(p3);
            binarySearchTree.insert(p4);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void insert(){
        insrtElemnts();
        assertEquals(4, binarySearchTree.size());
    }

    @org.junit.jupiter.api.Test
    void forEachPreorder(){
        insrtElemnts();
        ArrayList<Person> persons = new ArrayList<>();
        binarySearchTree.forEach(p -> persons.add((Person)p), Traversal.PREORDER);
        for (Person p : persons) {
            assertTrue(binarySearchTree.contains(p));
        }
    }

    @org.junit.jupiter.api.Test
    void forEachInorder(){
        insrtElemnts();
        ArrayList<Person> persons = new ArrayList<>();
        binarySearchTree.forEach(p -> persons.add((Person)p), Traversal.INORDER);
        for (Person p : persons) {
            assertTrue(binarySearchTree.contains(p));
        }
    }

    @org.junit.jupiter.api.Test
    void forEachPostorder(){
        insrtElemnts();
        ArrayList<Person> persons = new ArrayList<>();
        binarySearchTree.forEach(p -> persons.add((Person)p), Traversal.POSTORDER);
        for (Person p : persons) {
            assertTrue(binarySearchTree.contains(p));
        }
    }

    @org.junit.jupiter.api.Test
    void find(){
        insrtElemnts();
        Person p = new Person("Person 10", 10);
        keyExtractor.addItem(p,p.getId());
        try {
            binarySearchTree.insert(p);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(p, binarySearchTree.find(10));
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void contains(){
        insrtElemnts();
        Person p = new Person("Person 10", 10);
        keyExtractor.addItem(p,p.getId());
        try {
            binarySearchTree.insert(p);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }

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
        try {
            binarySearchTree.insert(p);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
        assertEquals(p, binarySearchTree.max());
    }

    @org.junit.jupiter.api.Test
    void min(){
        insrtElemnts();
        Person p = new Person("Person 1", 1);
        keyExtractor.addItem(p,p.getId());
        try {
            binarySearchTree.insert(p);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
        assertEquals(p, binarySearchTree.min());
    }

    @org.junit.jupiter.api.Test
    void max_nth(){
        insrtElemnts();
        Person p = new Person("Person 100", 100);
        keyExtractor.addItem(p,p.getId());
        try {
            binarySearchTree.insert(p);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
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
        try {
            binarySearchTree.insert(p1);
            binarySearchTree.insert(p2);
            binarySearchTree.insert(p3);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }

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
        try {
            binarySearchTree.insert(p1);
            binarySearchTree.insert(p2);
            binarySearchTree.insert(p3);
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }

        assertTrue(binarySearchTree.isComplete());
    }

    @org.junit.jupiter.api.Test
    void isCompleteTestNotComplete(){
        insrtElemnts();
        assertFalse(binarySearchTree.isComplete());
    }

    @org.junit.jupiter.api.Test
    void removeByKey(){
        insrtElemnts();
        binarySearchTree.remove(5);
        int size =binarySearchTree.size();
        assertEquals(3, binarySearchTree.size());
    }


    @org.junit.jupiter.api.Test
    void BFS() {
        insrtElemnts();
        ArrayList<Person> persons = new ArrayList<>();
        binarySearchTree.forEach(p -> persons.add((Person) p), Traversal.BFS);
        for (Person p : persons) {
            assertTrue(binarySearchTree.contains(p));
        }
    }
}