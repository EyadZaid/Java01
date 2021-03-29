package training.expires;

public class IntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}
