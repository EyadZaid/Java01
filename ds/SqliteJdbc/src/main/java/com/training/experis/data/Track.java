package com.training.experis.data;

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

    public Track(String trackId, String name, String albumId, String mediaTypeId, String genreId, String composer,
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

    public String getTrackId() {
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