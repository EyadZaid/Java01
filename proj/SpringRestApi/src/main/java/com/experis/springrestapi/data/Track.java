package com.experis.springrestapi.data;

public class Track {
    private final String trackId;
    private final String name;
    private final String albumId;
    private final float unitPrice;

    public Track(String trackId, String name, String albumId, float unitPrice) {
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
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