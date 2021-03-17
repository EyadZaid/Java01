package training.expires;

public class Main {

    public static void testMyStack(){
        MyStack myStack = new MyStack();

        System.out.println("Stack is empty: " + myStack.isEmpty() );

        myStack.push(10);
        myStack.push(-5);
        myStack.push(864);
        myStack.push(-45);

        System.out.println("Size of stack: " + myStack.size());

        myStack.pop();
        myStack.pop();

        System.out.println("Size of stack: " + myStack.size());
        System.out.println("Pop from the stack: " + myStack.pop());

        myStack.pop();
        myStack.pop();

        //Create new Stack with size
        MyStack stack = new MyStack(-5);
    }

    public static void main(String[] args) {
        testMyStack();
    }
}
