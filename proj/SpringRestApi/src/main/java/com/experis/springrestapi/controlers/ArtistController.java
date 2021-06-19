package com.experis.springrestapi.controlers;

import com.experis.springrestapi.entities.Album;
import com.experis.springrestapi.entities.Artist;
import com.experis.springrestapi.services.IDbService;
import com.experis.springrestapi.services.jdbcTemplate.AlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    @Autowired
    private IDbService iDbService;

    @Autowired
    private AlbumsService albumsService;

    /**
     * Get all artists
     */
    @GetMapping("/artist/all")
    public @ResponseBody List<Artist> getArtists() {
        return iDbService.getAllArtists();
    }


    /**
     * Get albums by artist id
     */
    @GetMapping("/artist")
    public List<Album> getAlbumsByArtistId(@RequestParam(value = "id", defaultValue = "2") String artistId) {
        //return iDbService.getAlbumsByArtistId(artistId);
        return albumsService.getAlbumsByArtistId(artistId);
    }


    /**
     * Add new artist to DB
     */
    @PostMapping("/artist")
    public boolean addArtist(@RequestParam("name") String name) {
        return iDbService.createArtist(name);
    }


}
