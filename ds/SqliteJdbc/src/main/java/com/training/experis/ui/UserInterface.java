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

        scanner.nextLine();
        System.out.println("\nEnter artist name: ");
        String artistName = scanner.nextLine();
        var albums = getAlbumsByArtistName(artistName);
        for (var e : albums) {
            System.out.println(e);
        }

        System.out.println("\nEnter album id: ");
        int albumId = scanner.nextInt();
        Map<Integer, Track> tracks = getAllTracksByAlbumId(albumId);
        for (var e : tracks.values()) {
            System.out.println(e);
        }

        int trackId = getTrackId(tracks);
        Track track = tracks.get(trackId);
        createInvoice(user, track, 1);
    }

    private User getUser() {
        User user;
        do {
            System.out.println("Enter your id: ");
            int userId = scanner.nextInt();

            user = getUserById(userId);
        } while (user == null);

        return user;
    }

    private int getTrackId(Map<Integer, Track> tracks) {
        int trackId;
        do {
            System.out.println("\nEnter track id: ");
            trackId = scanner.nextInt();
        } while (!tracks.containsKey(trackId));

        return trackId;
    }
}
