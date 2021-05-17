package com.training.experis;

public class Artist {
    private final int id;
    private final String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }
}
