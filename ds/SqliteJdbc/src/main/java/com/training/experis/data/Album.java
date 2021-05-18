package com.training.experis.data;

public class Album {
    private final int id;
    private final String title;
    private final int artistId;

    public Album(int id, String title, int artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Album Id: ");
        str.append(id);
        str.append(", Title: ");
        str.append(title);
        return str.toString();
    }
}
