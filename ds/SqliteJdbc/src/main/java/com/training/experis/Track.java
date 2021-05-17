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

    public int getTrackId() {
        return trackId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Track Id: ");
        str.append(trackId);
        str.append(", Name: ");
        str.append(name);
        return str.toString();
    }
}