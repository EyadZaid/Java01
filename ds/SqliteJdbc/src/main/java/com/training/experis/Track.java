package com.training.experis;

public class Track {
    private final int trackId;
    private final String name;
    private final int albumId;
    private final int mediaTypeId;
    private final int genreId;
    private final String composer;
    private final int milliseconds;
    private final int bytes;
    private final float unitPrice;

    public Track(int trackId, String name, int albumId, int mediaTypeId, int genreId, String composer,
                 int milliseconds, int bytes, float unitPrice) {
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
        this.mediaTypeId = mediaTypeId;
        this.genreId = genreId;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", name='" + name + '\'' +
                ", albumId=" + albumId +
                ", mediaTypeId=" + mediaTypeId +
                ", genreId=" + genreId +
                ", composer='" + composer + '\'' +
                ", milliseconds=" + milliseconds +
                ", bytes=" + bytes +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
