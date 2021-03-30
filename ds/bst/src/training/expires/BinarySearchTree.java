package training.expires;

public class BinarySearchTree<T,K> {

   private static class Node<T,K> {
       private final K key;
       private final T value;
       private Node<T,K> left, right;

        public Node(K key, T value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node<T,K> root;
    private Comparator<K> comparator;
    private KeyExtractor<T,K> keyExtractor;
    private int size;

    public BinarySearchTree(KeyExtractor<T,K> keyExtractor, Comparator<K> comparator) {
        root = null;
        this.comparator = comparator;
        this.keyExtractor = keyExtractor;
    }


    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public void insert(K key, T value) {
        root = insert(root, key, value);
        size++;
    }


    private Node<T,K> insert(Node<T,K> root, K key, T value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        if (comparator.compare(root.key, key) > 0){   // new item < root
            root.left = insert(root.left, key, value);
        }
        else {
            if (comparator.compare(root.key, key) < 0){  // new item > root
                root.right = insert(root.right, key, value);
            }
        }
        return root;
    }


    public boolean contains(K key){
        if (contains(root, key) != null){
            return true;
        }
        return false;
    }


    private Node<T, K> contains(Node<T,K> node, K key){
        if (node == null ||  comparator.compare(node.key, key) == 0){
            return root;
        }

        if (comparator.compare(node.key, key) < 0) { // new item > root
            return contains(node.right, key);
        }

        return contains(node.left, key);  // new item < root
    }


    public T find(K needle){
       return find(root, needle);
    }


    private T find(Node<T,K> node, K needle) {
        T val = node.value;
        var key = keyExtractor.getKey(val);
        int c = comparator.compare(key,needle);

        if(c == 0){
            return val;
        }
        else if( c > 0){
            return find(node.right, needle);
        } else{
            return find(node.left, needle);
        }
    }


    /*
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
     */

    public void forEach(Action func){


    }

    public void inorderPrint() {
        inorderPrint(root);
    }

    void inorderPrint(Node rootTree) {
        if (rootTree != null) {
            inorderPrint(rootTree.left);
            System.out.println(rootTree.value);
            inorderPrint(rootTree.right);
        }
    }







}
