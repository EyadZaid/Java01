package training.expires;

public class Main {

    public static void main(String[] args) {
        testBinarySearchTree();
    }

    private static void testBinarySearchTree() {
        BinarySearchTree<Person, Integer> binarySearchTree;
        IKeyExtractor<Person, Integer> keyExtractor;
        keyExtractor = new KeyExtractorImpl<>();
        binarySearchTree = new BinarySearchTree<>(keyExtractor, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

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


        //binarySearchTree.forEach(a -> System.out.println(a), Traversal.PREORDER);
        binarySearchTree.forEach(a -> System.out.println(a), Traversal.INORDER);
        //binarySearchTree.forEach(a -> System.out.println(a), Traversal.POSTORDER);

        System.out.println("\nMax=" + binarySearchTree.max());

        System.out.println("\nMax by n=" + binarySearchTree.max_nth(4));

        System.out.println("\nHeight=" + binarySearchTree.height());
    }
}