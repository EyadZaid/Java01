package com.experis.springrestapi.data;

public class Album {
    private final String id;
    private final String title;
    private final int artistId;

    public Album(String id, String title, int artistId) {
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
