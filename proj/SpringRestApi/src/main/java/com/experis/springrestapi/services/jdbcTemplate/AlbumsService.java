package com.experis.springrestapi.services.jdbcTemplate;

import com.experis.springrestapi.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final RowMapper<Album> albumRowMapper = (resultSet, rowNum) -> {
        String albumId = resultSet.getString("AlbumId");
        String title = resultSet.getString("Title");
        String artistId = resultSet.getString("ArtistId");
        Album album = new Album(albumId, title, artistId);
        return album;
    };

    public List<Album> getAlbumsByArtistId(String artistId) {
        List<Album> albums = new ArrayList<>();

        var sqlPattern = """
                SELECT AlbumId, Title, ArtistId FROM albums 
                WHERE ArtistId = ?;
                """;

        return jdbcTemplate.query(sqlPattern, albumRowMapper, artistId);
    }
}
