package com.training.experis.ui;

import com.training.experis.data.Album;
import com.training.experis.data.Track;
import com.training.experis.data.User;
import com.training.experis.logic.IDbService;

import java.util.Map;
import java.util.Scanner;

public class Application {
    private final Scanner scanner;
    private final IDbService iDbService;

    public Application(IDbService iDbService) {
        this.scanner = new Scanner(System.in);
        this.iDbService = iDbService;
    }

    public void run () {
        User user = getUser();
        System.out.println(user);

        var albums = getAlbumsByArtistName();
        for (var e : albums.values()) {
            System.out.println(e);
        }

        var tracks = getTracksByAlbumId();
        for (var e : tracks.values()) {
            System.out.println(e);
        }

        var trackId = getTrackId(tracks);
        Track track = tracks.get(trackId);
        iDbService.createInvoice(user, track, 1);
    }

    private User getUser() {
        User user;
        do {
            System.out.println("Enter your id: ");
            String userId = scanner.nextLine();

            user = iDbService.getUserById(userId);
        } while (user == null);

        return user;
    }

    private String getTrackId(Map<String, Track> tracks) {
        String trackId;
        do {
            System.out.println("\nEnter track id: ");
            trackId = scanner.nextLine();
        } while (!tracks.containsKey(trackId));

        return trackId;
    }

    private Map<String, Album> getAlbumsByArtistName() {
        Map<String, Album> albums;
        do {
            System.out.println("\nEnter artist name: ");
            String artistName = scanner.nextLine();
            albums = iDbService.getAlbumsByArtistName(artistName);
        } while (albums.isEmpty());

        return albums;
    }

    private Map<String, Track> getTracksByAlbumId() {
        Map<String, Track> tracks;
        do {
            System.out.println("\nEnter album id: ");
            String albumId = scanner.nextLine();
            tracks = iDbService.getTracksByAlbumId(albumId);
        } while (tracks.isEmpty());

        return tracks;
    }
}
