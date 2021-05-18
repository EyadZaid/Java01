package com.training.experis.ui;

import com.training.experis.data.Track;
import com.training.experis.data.User;
import com.training.experis.logic.IService;

import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final IService iService;

    public UserInterface(IService iService) {
        this.scanner = new Scanner(System.in);
        this.iService = iService;
    }

    public void run () {
        User user = getUser();
        System.out.println(user);

        System.out.println("\nEnter artist name: ");
        String artistName = scanner.nextLine();
        var albums = iService.getAlbumsByArtistName(artistName);
        for (var e : albums) {
            System.out.println(e);
        }

        System.out.println("\nEnter album id: ");
        String albumId = scanner.nextLine();
        var tracks = iService.getAllTracksByAlbumId(albumId);
        for (var e : tracks.values()) {
            System.out.println(e);
        }

        var trackId = getTrackId(tracks);
        Track track = tracks.get(trackId);
        iService.createInvoice(user, track, 1);
    }

    private User getUser() {
        User user;
        do {
            System.out.println("Enter your id: ");
            String userId = scanner.nextLine();

            user = iService.getUserById(userId);
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
}
