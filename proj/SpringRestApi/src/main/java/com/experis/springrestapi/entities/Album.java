package com.experis.springrestapi.entities;

public class Album {
    private final String id;
    private final String title;
    private final String artistId;

    public Album(String id, String title, String artistId) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistId() {
        return artistId;
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
