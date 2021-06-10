package com.experis.springrestapi.layout;

import com.experis.springrestapi.data.Album;
import com.experis.springrestapi.data.Artist;
import com.experis.springrestapi.logic.DbService;
import com.experis.springrestapi.logic.IDbService;
import com.experis.springrestapi.logic.SqlHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    private final IDbService iDbService;

    public ArtistController() {
        iDbService = new DbService(new SqlHandler());
    }

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
        return iDbService.getAlbumsByArtistId(artistId);
    }


    /**
     * Add new artist to DB
     */
    @PostMapping("/artist")
    public boolean addArtist(@RequestParam("name") String name) {
        return iDbService.createArtist(name);
    }


}