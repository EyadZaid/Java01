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


    public boolean contains(T item){
        return contains(root, item);
    }


    private boolean contains(Node<T> rTree, T item){
        if (rTree == null ||  comparator.compare(rTree.item, item) == 0){
            return true;
        }

        if (comparator.compare(rTree.item, item) < 0) { // new item > root
            contains(rTree.right, item);
        }

        contains(rTree.left, item);  // new item < root

        return false;
    }


    public T find(T item){
        return find(root, item);
    }


    private T find(Node<T> rTree, T item){
        if (rTree == null ||  comparator.compare(rTree.item, item) == 0){
            return rTree.item;
        }

        if (comparator.compare(rTree.item, item) < 0) { // new item > root
            find(rTree.right, item);
        }

        find(rTree.left, item);  // new item < root

        return null;
    }





}
