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

    //Insert item to the container
    public void push(T item){
        stack.push(item);
        insertMinToStack(item);
    }

    //Insert minimum item if needed
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

    //Remove last item inserted to the container and return it
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


    //Get current minimum item in the container
    public T min(){
        if (!minStack.isEmpty()){
            return minStack.peek();
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return stack.iterator();  //java.util.Stack implements Iterable
    }

    public int size(){
        return stack.size();
    }


}
