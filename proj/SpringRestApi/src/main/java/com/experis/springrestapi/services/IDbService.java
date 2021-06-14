package com.experis.springrestapi.services;

import com.experis.springrestapi.entities.Album;
import com.experis.springrestapi.entities.Artist;
import com.experis.springrestapi.entities.Track;
import com.experis.springrestapi.entities.User;

import java.util.List;
import java.util.Map;

public interface IDbService {
    User getUserById(String userId);

    Map<String, Album> getAlbumsByArtistName(String artistName);

    Map<String, Track> getTracksByAlbumId(String albumId);

    boolean createInvoice(User user, Track track, int quantity);

    List<Artist> getAllArtists();

    List<Album> getAlbumsByArtistId(String artistId);

    boolean createArtist(String name);

    Map<Artist, List<Album>> getArtistsAndAlbums();

}
