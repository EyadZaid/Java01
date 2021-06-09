package com.experis.springrestapi.layout;

import com.experis.springrestapi.data.Artist;
import com.experis.springrestapi.logic.DbService;
import com.experis.springrestapi.logic.IDbService;
import com.experis.springrestapi.logic.SqlHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ArtistController {
    private final IDbService iDbService;

    public ArtistController() {
        iDbService = new DbService(new SqlHandler());
    }

    @GetMapping("/artist/all")
    public @ResponseBody
    List<Artist> getArtists() {
        var list = iDbService.getAllArtists();
        return list;
    }

}
