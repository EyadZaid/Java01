package training.expires;

import java.util.HashMap;
import java.util.Map;

public class KeyExtractorImpl<T,K> implements IKeyExtractor<T,K>{

    private HashMap<K, T> allItems = new HashMap<>();

    @Override
    public void addItem(T value, K key) {
        allItems.put(key, value);
    }

    @Override
    public T getItem(K key){
        return allItems.get(key);
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
