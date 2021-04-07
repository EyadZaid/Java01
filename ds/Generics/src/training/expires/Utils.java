package training.expires;

import java.util.List;

public class Utils {


    public static Number averageOfList(List<? extends Number> list){
        if (list == null || list.size() == 0){
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
        if (list == null || list.size() == 0){
            return null;
        }

        if (list.size() == 1){
            return list.get(0);
        }

        return list.get(list.size()/2);
    }


    public static <T extends Comparable<T>> T maxElementInList(List<T> list){
        if (list == null || list.size() == 0){
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
        if (list == null || list.size() == 0){
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
        if (list == null || list.size() == 0){
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
        if (list == null || list.size() == 0){
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
            if (element.compareTo(min) < 0){
                min = element;
            }
        }
        return new MinAndMaxPair<T>(min, max);
    }


    public static <T extends Comparable<T>> T removeMinInList(List<T> list){
        if (list == null || list.size() == 0){
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
        if (list == null || list.size() == 0){
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



}
