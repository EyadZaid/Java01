package training.expires;

public class BinarySearchTree<T> {

   private class Node<T> {
        T item;
        Node left, right;

        public Node(T item) {
            this.item = item;
            left = right = null;
        }
    }

    private Node<T> root;
    private Comparator<T> comparator;
    private int size;

    public BinarySearchTree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(T item) {
        root = insert(root, item);
    }

    private Node<T> insert(Node<T> root, T item) {
        if (root == null) {
            root = new Node(item);
            return root;
        }

        if (comparator.compare(root.item, item) > 0){   // new item < root
            root.left = insert(root.left, item);
        }
        else {
            if (comparator.compare(root.item, item) < 0){  // new item > root
                root.right = insert(root.right, item);
            }
        }

        return root;
    }


}
