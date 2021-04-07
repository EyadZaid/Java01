package training.expires;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.2);
        list.add(4.3);
        list.add(20.5);

        System.out.println(Utils.averageOfList(list));
        System.out.println(Utils.midElementOfList(list));
        System.out.println(Utils.minAndMaxElementInList(list));
        System.out.println(Utils.bubbleSortList(list));
        System.out.println(Utils.removeMinInList(list));

    }
}
