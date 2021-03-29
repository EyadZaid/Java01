package training.expires;

public class Main {

    public static void main(String[] args) {
        //testDoublyLinkedList();

        testSortedPointListByX();
        testSortedPointListByLength();
        testSortedPointListByLengthDesc();

    }

    public static void testSortedPointListByX() {
        SortedPointList list = new SortedPointList(new PointComparator() {
            @Override
            public int compare(Point a, Point b) {
                return a.x - b.x;
            }
        });

        list.addPoint(new Point(5, 8));
        list.addPoint(new Point(2, 4));
        list.addPoint(new Point(15, 6));
        list.addPoint(new Point(-4, 48));

        System.out.println("Sorted Points List By X:");
        System.out.println(list);

        System.out.println("Reverse Sorted Points List By X:");
        list.reverseRecur();

        System.out.println(list);
    }


    public static void testSortedPointListByLength() {
        SortedPointList list = new SortedPointList(new PointComparator() {
            @Override
            public int compare(Point a, Point b) {
                return (int) (Math.sqrt((a.x)*(a.x) + (a.y)*(a.y)) -
                        Math.sqrt((b.x)*(b.x) + (b.y)*(b.y)));
            }
        });

        list.addPoint(new Point(5, 8));
        list.addPoint(new Point(2, 4));
        list.addPoint(new Point(15, 6));
        list.addPoint(new Point(-4, 48));

        System.out.println("Sorted Points List By length:");
        System.out.println(list);
    }


    public static void testSortedPointListByLengthDesc() {
        SortedPointList list = new SortedPointList(new PointComparator() {
            @Override
            public int compare(Point a, Point b) {
                return (int) (Math.sqrt((a.x)*(a.x) + (a.y)*(a.y)) -
                        Math.sqrt((b.x)*(b.x) + (b.y)*(b.y))) * -1;
            }
        });

        list.addPoint(new Point(5, 8));
        list.addPoint(new Point(2, 4));
        list.addPoint(new Point(15, 6));
        list.addPoint(new Point(-4, 48));

        System.out.println("Sorted Points List By length (Desc):");
        System.out.println(list);
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
