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

        Number sum=0;
        for (Number num : list){
            sum = sum.doubleValue() + num.doubleValue();
        }

        return sum.doubleValue()/(double)list.size();
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
            if (element.compareTo(max) > 0){
                max = element;
            }
        }
        return max;
    }


    public static <T extends Comparable<T>> MinAndMax<T> minAndMaxElementInList(List<T> list){
        if (list == null || list.size() == 0){
            return null;
        }

        if (list.size() == 1){
            return new MinAndMax<T>(list.get(0), list.get(0));
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
        return new MinAndMax<T>(min, max);
    }







}
