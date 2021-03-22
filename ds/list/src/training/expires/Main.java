package training.expires;

public class Main {

    public static void main(String[] args) {
        testDoublyLinkedList();
    }

    public static void testDoublyLinkedList(){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        for (int i=1; i<=10; i++){
            list.addAtTail(i);
        }
        System.out.println(list);

        for (int i=20; i<=25; i++){
            list.addAtHead(i);
        }
        System.out.println(list);

        list.insert(555, 6);
        System.out.println(list);

        list.remove(6);
        System.out.println(list);

        System.out.println("Find item by index:  Index= " + list.find(1));
        System.out.println("Find item by index:  Index= " + list.find(30));
        
    }
}
