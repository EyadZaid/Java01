package com.training.experis;

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
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                '}';
    }
}
