package training.expires;

import java.util.function.Function;

public class BinarySearchTree<T> {

   private static class Node<T> {
        T item;
        Node<T> left, right;

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
        size++;
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
        if (contains(root, item) != null){
            return true;
        }
        return false;
    }


    private Node<T> contains(Node<T> rTree, T item){
        if (rTree == null ||  comparator.compare(rTree.item, item) == 0){
            return root;
        }

        if (comparator.compare(rTree.item, item) < 0) { // new item > root
            return contains(rTree.right, item);
        }

        return contains(rTree.left, item);  // new item < root
    }


    public T find(T item){
        Node<T> node = find(root, item);
        if (node != null){
            return node.item;
        }
        return null;
    }


    private Node<T> find(Node<T> rTree, T item){
        if (rTree == null ||  comparator.compare(rTree.item, item) == 0){
            return rTree;
        }

        if (comparator.compare(rTree.item, item) < 0) { // new item > root
            return find(rTree.right, item);
        }

        return find(rTree.left, item);  // new item < root
    }

    public void forEach(Action func){


    }

    public void inorderPrint() {
        inorderPrint(root);
    }

    void inorderPrint(Node rootTree) {
        if (rootTree != null) {
            inorderPrint(rootTree.left);
            System.out.println(rootTree.item);
            inorderPrint(rootTree.right);
        }
    }







}
