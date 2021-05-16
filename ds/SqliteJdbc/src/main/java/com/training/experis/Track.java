package com.training.experis;

public class Track {
    private final String trackId;
    private final String name;
    private final String albumId;
    private final String mediaTypeId;
    private final String genreId;
    private final String composer;
    private final int milliseconds;
    private final int bytes;
    private final float unitPrice;

    public Track(String trackId, String name, String albumId, String mediaTypeId,
                 String genreId, String composer, int milliseconds, int bytes, float unitPrice) {
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
                "trackId='" + trackId + '\'' +
                ", name='" + name + '\'' +
                ", albumId='" + albumId + '\'' +
                ", mediaTypeId='" + mediaTypeId + '\'' +
                ", genreId='" + genreId + '\'' +
                ", composer='" + composer + '\'' +
                ", milliseconds=" + milliseconds +
                ", bytes=" + bytes +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
