package com.experis;

import java.util.ArrayList;
import java.util.List;

public class Cell<K,V> {
    private K key;
    private final List<V> list = new ArrayList<>();

    public Cell() {

    }
    public Cell(K key) {
        this.key = key;
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
