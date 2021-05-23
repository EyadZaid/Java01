package com.experis;

import java.util.ArrayList;
import java.util.List;

public class Cell<K,V> {
    private final K key;
    private final List<V> list;

    public Cell(K key) {
        this.key = key;
        list = new ArrayList<>();
    }

    public void addValue(V val) {
        list.add(val);
    }

    public List<V> getValues() {
        return list;
    }

    public K getKey() {
        return key;
    }
}
