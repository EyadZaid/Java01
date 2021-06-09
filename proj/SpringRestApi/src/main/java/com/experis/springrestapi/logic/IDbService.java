package com.experis.springrestapi.logic;

import com.experis.springrestapi.data.Album;
import com.experis.springrestapi.data.Track;
import com.experis.springrestapi.data.User;

import java.util.Map;

public interface IDbService {
    User getUserById(String userId);

    Map<String, Album> getAlbumsByArtistName(String artistName);

    Map<String, Track> getTracksByAlbumId(String albumId);

    boolean createInvoice(User user, Track track, int quantity);

}
