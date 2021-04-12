package training.expires;

import java.util.Iterator;
import java.util.Stack;

public class GenericContainer<T extends Comparable<T>> implements Iterable<T> {
    private Stack<T> stack;
    private Stack<T> minStack;

    public GenericContainer(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T item){
        stack.push(item);
        insertMinToStack(item);
    }

    private void insertMinToStack(T item){
        if (minStack.isEmpty()){
            minStack.push(item);
        }
        else {
            if (minStack.peek().compareTo(item) >= 0) {
                minStack.push(item);
            }
        }
    }

    public T pop(){
        if (stack.isEmpty()){
            return null;
        }

        T item = stack.pop();
        if (minStack.peek().compareTo(item) == 0){
            minStack.pop();
        }
        return item;
    }


    public T min(){
        if (!minStack.isEmpty()){
            return minStack.peek();
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    public int size(){
        return stack.size();
    }


}
