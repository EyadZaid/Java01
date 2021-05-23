package com.experis;

import java.util.HashMap;
import java.util.List;

public class MultiValuedMap<K, V> {
    private final HashMap<K, Cell<K,V>> map = new HashMap<>();

    public void put(K key, V val) {
        var cell = map.get(key);
        if (cell != null) {
            cell.addValue(val);
        }
        else {
            Cell<K, V> newCell = new Cell<>(key);
            newCell.addValue(val);
            map.put(key, newCell);
        }
    }

    public List<V> get(K key) {
        var cell = map.get(key);
        if (key == null) {
            return null;
        }
        return cell.getValues();
    }


}
