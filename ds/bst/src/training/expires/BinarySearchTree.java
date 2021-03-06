package training.expires;

import java.util.ArrayList;

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


    public void insert(T item) throws ItemExistsException {
        if (contains(item)){
            throw new ItemExistsException("Exception: Item already exists");
        }
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
        if (contains(root, item)){
            return true;
        }
        return false;
    }


    private boolean contains(Node<T> node, T item){

        if (node == null){
            return false;
        }

        K keyItem = keyExtractor.getKey(item);
        K nodeKey = keyExtractor.getKey(node.item);
        int c = comparator.compare(keyItem, nodeKey);

        if (c == 0){
            return true;
        }

        if(c < 0 && node.left != null && contains(node.left, item)){
            return true;
        }

        if(c > 0 && node.right != null && contains(node.right, item)) {
            return true;
        }

        return false;
    }


    public T find(K needle) throws ItemExistsException {
        if (! contains(keyExtractor.getItem(needle))){
            throw new ItemExistsException("Exception: Item not exists");
        }

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
            case BFS -> BFS(func);
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

    private void BFS(Action func){
        for (int i=1; i<=height(); i++) {
            BFS(root, i, func);
        }
    }


    private void BFS(Node<T> node, int currHeight, Action func){
        if (node == null) {
            return;
        }
        if (currHeight == 1) {
            func.apply(node.item);
        }
        else {
            if (currHeight > 1) {
                BFS(node.left, currHeight - 1, func);
                BFS(node.right, currHeight - 1, func);
            }
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
            return min(node.left);
        }
    }


    public T max_nth(int num){
        ArrayList<T> list = new ArrayList<>();
        max_nth(root, list);
        if (num > 0 && num <= list.size()){
            return list.get(num-1);
        }
        return null;
    }


    private void max_nth(Node<T> node, ArrayList<T> list){
        if (node != null) {
            max_nth(node.left, list);
            list.add(node.item);
            max_nth(node.right, list);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);
            }
            else {
                return (rDepth + 1);
            }
        }
    }


    public boolean isPerfect(){
        return isPerfect(root, height(), 0);
    }

    private boolean isPerfect(Node<T> node, int height, int currHeight){
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return (height == currHeight + 1);
        }

        if (node.left == null || node.right == null) {
            return false;
        }

        return isPerfect(node.left, height, currHeight+1) && isPerfect(node.right, height, currHeight+1);
    }


    public boolean isComplete(){
        return isComplete(root, 0, size);
    }


    private boolean isComplete(Node<T> root, int index, int sizeTree) {
        if (root == null) {
            return true;
        }

        if (index >= sizeTree) {
            return false;
        }

        return (isComplete(root.left, 2 * index + 1, sizeTree)
                && isComplete(root.right, 2 * index + 2, sizeTree));
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

                Node<T> temp = node;
                node = min(temp.right);
                node.right = removeMin(temp.right);
                node.left = temp.left;
            }
        }
        return node;
    }



    private Node<T> removeMin(Node<T> node) {
        if (node.left == null){
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    /*
    public <R> R reduce(R r, BiFunc<R,T,R> func){
        return reduce(root, r, func);
    }

    private <R> R reduce(Node<T> rootTree, R r, BiFunc<R,T,R> func){
        if (rootTree != null) {
            reduce(rootTree.left, r, func);
            reduce(rootTree.right, r, func);
            return func.apply(r, rootTree.item);
        }
        return r;
    }
    */


}
