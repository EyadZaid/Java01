package com.training.experis.logic;

import com.training.experis.data.Album;
import com.training.experis.data.Track;
import com.training.experis.data.User;

import java.util.Map;

public interface IDbService {
    User getUserById(String userId);

    Map<String, Album> getAlbumsByArtistName(String artistName);

    Map<String, Track> getTracksByAlbumId(String albumId);

    boolean createInvoice(User user, Track track, int quantity);

}
