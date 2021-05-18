package com.training.experis.logic;

import com.training.experis.data.Album;
import com.training.experis.data.Track;
import com.training.experis.data.User;

import java.util.List;
import java.util.Map;

public interface IService {
    User getUserById(String userId);

    List<Album> getAlbumsByArtistName(String artistName);

    Map<String, Track> getAllTracksByAlbumId(String albumId);

    void createInvoice(User user, Track track, int quantity);

}
