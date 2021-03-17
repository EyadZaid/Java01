package training.expires;

public class Main {

    public static void testIntQueue(){
        IntQueue queue = new IntQueue(2);

        System.out.println(queue);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);

        System.out.println(queue);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println(queue);
    }


    public static void testIntQueueWithStack(){
        IntQueueWithStack queue = new IntQueueWithStack(3);

        System.out.println(queue);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
    }


    public static void testIntStackMin(){
        IntStackMin stack = new IntStackMin();

        stack.push(1, 2, 16, 2, 1, 25, -5, 17);

        System.out.println("Min = " + stack.min());

        System.out.println("Pop = " + stack.pop());
        System.out.println("Pop = " + stack.pop());

        System.out.println("Min = " + stack.min());

        System.out.println("Pop = " + stack.pop());

        System.out.println("Min = " + stack.min());

        System.out.println("Pop = " + stack.pop());
        System.out.println("Pop = " + stack.pop());

        System.out.println("Min = " + stack.min());

    }


    public static void testMyStack(){
        IntStack myStack = new IntStack();

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

        //Exception: Out of range, stack is full
        int[] nums = {5, -3, 3, 6, 1568, 26, 58, -26, 99};
        myStack.push(nums);

        //Create new Stack with size
        IntStack stack = new IntStack(-5);
    }

    public static void main(String[] args) {
        //testMyStack();
        //testIntStackMin();
        //testIntQueue();
        testIntQueueWithStack();
    }
}
