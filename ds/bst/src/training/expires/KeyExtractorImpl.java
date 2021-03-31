package training.expires;

import java.util.HashMap;
import java.util.Map;

public class KeyExtractorImpl<T,K> implements IKeyExtractor<T,K>{

    private HashMap<K, T> allItems = new HashMap<>();

    public void addItem(T value, K key) {
        allItems.put(key, value);
    }


    @Override
    public K getKey(T obj) {
        K key = null;
        for (Map.Entry<K, T> entry : allItems.entrySet()) {
            if (entry.getValue().equals(obj)) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }
}
