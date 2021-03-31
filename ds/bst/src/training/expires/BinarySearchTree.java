package training.expires;

public class BinarySearchTree<T,K> {

   private static class Node<T> {
       private final T item;
       private Node<T> left, right;

        public Node(T item) {
            this.item = item;
            left = right = null;
        }
    }

    private Node<T> root;
    private Comparator<K> comparator;
    private IKeyExtractor<T,K> keyExtractor;
    private int size;

    public BinarySearchTree(IKeyExtractor<T,K> keyExtractor, Comparator<K> comparator) {
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


    public void insert(T item) {
        root = insert(root, item);
        size++;
    }


    private Node<T> insert(Node<T> root, T item) {
        if (root == null) {
            root = new Node(item);
            return root;
        }

        K keyNewItem = keyExtractor.getKey(item);
        K rootKey = keyExtractor.getKey(root.item);
        if (comparator.compare(rootKey, keyNewItem) > 0){   // new item < root
            root.left = insert(root.left, item);
        }
        else {
            if (comparator.compare(rootKey, keyNewItem) < 0){  // new item > root
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


    private Node<T> contains(Node<T> node, T item){
        K keyItem = keyExtractor.getKey(item);
        K nodeKey = keyExtractor.getKey(node.item);
        if (node == null ||  comparator.compare(nodeKey, keyItem) == 0){
            return root;
        }

        if (comparator.compare(nodeKey, keyItem) < 0) { // new item > root
            return contains(node.right, item);
        }

        return contains(node.left, item);  // new item < root
    }


    public T find(K needle){
        Node<T> node = find(root, needle);
        if (node != null){
            return node.item;
        }
        return null;
    }


    private Node<T> find(Node<T> node, K needle) {
        T val = node.item;
        var key = keyExtractor.getKey(val);
        int c = comparator.compare(key,needle);

        if(c == 0){
            return node;
        }
        else if( c > 0){
            return find(node.left, needle);
        } else{
            return find(node.right, needle);
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

    public void forEach(Action func, Traversal order){
        switch (order){
            case PREORDER -> preorder(root, func);
            case INORDER -> inorder(root, func);
            case POSTORDER -> postOrder(root, func);
        }
    }

    private void preorder(Node<T> rootTree, Action func){
        if (rootTree != null) {
            func.apply(rootTree.item);
            preorder(rootTree.left, func);
            preorder(rootTree.right, func);
        }
    }

    private void inorder(Node<T> rootTree, Action func){
        if (rootTree != null) {
            inorder(rootTree.left, func);
            func.apply(rootTree.item);
            inorder(rootTree.right, func);
        }
    }

    private void postOrder(Node<T> rootTree, Action func){
        if (rootTree != null) {
            postOrder(rootTree.left, func);
            postOrder(rootTree.right, func);
            func.apply(rootTree.item);
        }
    }


    public T max() {
        if (root != null){
            return max(root).item;
        }
        return null;
    }


    private Node<T> max(Node<T> node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }


    public T min() {
        if (root != null){
            return min(root).item;
        }
        return null;
    }


    private Node<T> min(Node<T> node) {
        if (node.left == null) {
            return node;
        } else {
            return max(node.left);
        }
    }


    public void remove(K key) {
        if (key != null){
            root = remove(root, key);
            size--;
        }
    }


    private Node<T> remove(Node<T> node, K key) {
        if (node == null){
            return null;
        }
        K nodeKey = keyExtractor.getKey(node.item);
        int c = comparator.compare(key, nodeKey);
        if (c < 0){
            node.left  = remove(node.left,  key);
        }
        else {
            if (c > 0) {
                node.right = remove(node.right, key);
            }
            else {
                if (node.right == null) {
                    return node.left;
                }
                if (node.left  == null) {
                    return node.right;
                }
            }
        }
        return node;
    }


    public void inorderPrint() {
        inorderPrint(root);
    }

    void inorderPrint(Node<T> rootTree) {
        if (rootTree != null) {
            inorderPrint(rootTree.left);
            System.out.println(rootTree.item);
            inorderPrint(rootTree.right);
        }
    }




}
