package training.expires;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {


    public static Number averageOfList(List<? extends Number> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return list.get(0);
        }

        double sum=0;
        for (Number num : list){
            sum += num.doubleValue();
        }

        return sum/(double)list.size();
    }


    public static <T> T midElementOfList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return list.get(0);
        }

        return list.get(list.size()/2);
    }


    public static <T extends Comparable<T>> T maxElementInList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return list.get(0);
        }

        T max = list.get(0);
        for (int i=1; i<list.size(); i++){
            T element = list.get(i);
            if (element.compareTo(max) >= 0){
                max = element;
            }
        }
        return max;
    }


    public static <T extends Comparable<T>> T minElementInList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return list.get(0);
        }

        T min = list.get(0);
        for (int i=1; i<list.size(); i++){
            T element = list.get(i);
            if (element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }


    public static <T extends Comparable<T>> int indexOFMinInList(List<T> list){
        if (list == null || list.isEmpty()){
            return -1;
        }

        if (list.size() == 1){
            return 0;
        }

        T min = list.get(0);
        int indexMin = 0;
        for (int i=1; i<list.size(); i++){
            T element = list.get(i);
            if (element.compareTo(min) < 0){
                min = element;
                indexMin = i;
            }
        }
        return indexMin;
    }


    public static <T extends Comparable<T>> MinAndMaxPair<T> minAndMaxElementInList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return new MinAndMaxPair<T>(list.get(0), list.get(0));
        }

        T max, min;
        max = min = list.get(0);
        for (int i=1; i<list.size(); i++){
            T element = list.get(i);
            if (element.compareTo(max) > 0){
                max = element;
            }
            else {
                if (element.compareTo(min) < 0){
                    min = element;
                }
            }
        }
        return new MinAndMaxPair<T>(min, max);
    }


    public static <T extends Comparable<T>> T removeMinInList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        if (list.size() == 1){
            return list.remove(0);
        }

        int indexMin = indexOFMinInList(list);
        if (indexMin == -1){
            return null;
        }

        return list.remove(indexMin);
    }


    public static <T extends Comparable<T>> List<T> bubbleSortList(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        int size = list.size();
        if (list.size() == 1){
            return list;
        }

        boolean endSorted;
        for (int i=0; i<size-1; i++) {
            endSorted = true;
            for (int j=0; j< size-i-1; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                    endSorted = false;
                }
            }
            if (endSorted == true) {
                break;
            }
        }
        return list;
    }


    //
    //
    //
    //
    //

    public static <T extends Comparable<T>> T minElementWithIterator(List<T> list){
        if (list == null || list.isEmpty()){
            return null;
        }

        Iterator<T> iterator = list.iterator();
        T min = iterator.next();

        while (iterator.hasNext()){
            T element = iterator.next();
            if (element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }


    public static <T extends Comparable<T>> MinAndMaxPair<T> MinAndMaxAdvanced(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        if (list.size() == 1) {
            return new MinAndMaxPair<T>(list.get(0), list.get(0));
        }

        T max, min;

        if (list.get(0).compareTo(list.get(1)) > 0) {
            max = list.get(0);
            min = list.get(1);
        }
        else {
            max = list.get(1);
            min = list.get(0);
        }

        for (int i = 2; i <= list.size()- 2; i+=2) {
            if (list.get(i).compareTo(list.get(i+1)) > 0) {
                min = min.compareTo(list.get(i+1)) > 0 ? list.get(i+1) : min;
                max = max.compareTo(list.get(i)) < 0 ? list.get(i) : max;
            } else {
                min = min.compareTo(list.get(i)) > 0 ? list.get(i) : min;
                max = max.compareTo(list.get(i+1)) < 0 ? list.get(i+1) : max;
            }
        }

        int size = list.size();
        if (size % 2 == 1) {
            min = min.compareTo(list.get(size-1)) > 0 ? list.get(size-1) : min;
            max = max.compareTo(list.get(size-1)) < 0 ? list.get(size-1) : max;
        }

        return new MinAndMaxPair<T>(min, max);
    }


    public static <T extends Comparable<T>> MinAndMaxPair<T> MinAndMaxAdvancedWithIterator(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        int size = list.size();
        if (size == 1) {
            return new MinAndMaxPair<T>(list.get(0), list.get(0));
        }

        T max, min, a, b;
        Iterator<T> it = list.iterator();
        a = it.next();
        b = it.next();
        if (a.compareTo(b) > 0) {
            max = a;
            min = b;
        }
        else {
            max = b;
            min = a;
        }

        while (it.hasNext()){
            a = it.next();
            if (it.hasNext()){
                b = it.next();
            }
            else {
                break;
            }

            if (a.compareTo(b) > 0) {
                min = min.compareTo(b) > 0 ? b : min;
                max = max.compareTo(a) < 0 ? a : max;
            } else {
                min = min.compareTo(a) > 0 ? a : min;
                max = max.compareTo(b) < 0 ? b : max;
            }
        }

        if (size % 2 == 1) {
            min = min.compareTo(a) > 0 ? a : min;
            max = max.compareTo(a) < 0 ? a : max;
        }

        return new MinAndMaxPair<T>(min, max);
    }


    public static List<Number> listGenerator(double start, double step, int size){
        List<Number> list = new ArrayList<>();
        double n = start;
        list.add(n);

        for (int i=1; i<size; i++){
            n += step;
            list.add(n);
        }
        return list;
    }


    public static <T> List<T> listGenerator(T start, T step, int size, BiFunc<T, T, T> add){
        List<T> list = new ArrayList<>();
        T obj = start;
        list.add(obj);

        for (int i=1; i<size; i++){
            obj = add.apply(obj, step);
            list.add(obj);
        }
        return list;
    }

}
