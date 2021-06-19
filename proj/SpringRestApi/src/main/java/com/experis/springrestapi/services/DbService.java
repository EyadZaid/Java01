package com.experis.springrestapi.services;

import com.experis.springrestapi.entities.Album;
import com.experis.springrestapi.entities.Artist;
import com.experis.springrestapi.entities.Track;
import com.experis.springrestapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Profile("dev")
public class DbService implements IDbService {
    @Autowired
    private final ISqlHandler sqlHandler;

    public DbService(ISqlHandler sqlHandler) {
        this.sqlHandler = sqlHandler;
    }

    @Override
    public User getUserById(String userId) {
        User user = null;

        var sqlPattern = """
                SELECT FirstName, Email, City, Address, State, Country, PostalCode FROM customers 
                where CustomerId = ?;
                """;

        var rs = sqlHandler.executeQuery(sqlPattern, userId);
        try {
            String name = rs.getString("FirstName");
            String city = rs.getString("City");
            String email = rs.getString("Email");
            String address = rs.getString("Address");
            String state = rs.getString("State");
            String country = rs.getString("Country");
            String postalCode = rs.getString("PostalCode");
            user = new User(userId, name, email, city, address, state, country, postalCode);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public Map<String, Album> getAlbumsByArtistName(String artistName) {
        Map<String, Album> albums = new HashMap<>();

        var sqlPattern = """
                SELECT alb.AlbumId, alb.Title, alb.ArtistId FROM artists as art 
                inner join albums alb on art.ArtistId = alb.ArtistId WHERE art.NAME LIKE ?;
                """;

        var parameter = "%" + artistName + "%";
        var rs = sqlHandler.executeQuery(sqlPattern, parameter);
        try {
            while (rs.next()) {
                String id = rs.getString("AlbumId");
                String title = rs.getString("Title");
                String artistId = rs.getString("ArtistId");
                Album album = new Album(id, title, artistId);
                albums.put(id, album);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return albums;
    }

    @Override
    public Map<String, Track> getTracksByAlbumId(String albumId) {
        Map<String, Track> tracks = new HashMap<>();

        var sqlPattern = """
                SELECT TrackId, Name, UnitPrice FROM tracks 
                WHERE AlbumId = ?;
                """;

        var rs = sqlHandler.executeQuery(sqlPattern, albumId);
        try {
            while (rs.next()) {
                String id = rs.getString("TrackId");
                String name = rs.getString("Name");
                float unitPrice = rs.getFloat("UnitPrice");

                Track track = new Track(id, name, albumId, unitPrice);
                tracks.put(id, track);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tracks;
    }

    @Override
    public boolean createInvoice(User user, Track track, int quantity) {
        float total = quantity * track.getUnitPrice();
        int invoiceId = insertInvoice(user, total);
        if (invoiceId == -1){
            return false;
        }

        return insertInvoiceItems(track, invoiceId, quantity);
    }

    @Override
    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();

        var sqlPattern = """
                SELECT ArtistId, Name FROM artists;
                """;

        var rs = sqlHandler.executeQuery(sqlPattern);
        try {
            while (rs.next()) {
                String id = rs.getString("ArtistId");
                String name = rs.getString("Name");

                Artist artist = new Artist(id, name);
                artists.add(artist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return artists;
    }

    @Override
    public List<Album> getAlbumsByArtistId(String artistId) {
        List<Album> albums = new ArrayList<>();

        var sqlPattern = """
                SELECT AlbumId, Title, ArtistId FROM albums 
                WHERE ArtistId = ?;
                """;

        var rs = sqlHandler.executeQuery(sqlPattern, artistId);
        try {
            while (rs.next()) {
                String albumId = rs.getString("AlbumId");
                String title = rs.getString("Title");

                Album album = new Album(albumId, title, artistId);
                albums.add(album);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return albums;
    }

    @Override
    public boolean createArtist(String name) {
        var sqlPattern = """
                INSERT INTO artists (NAME) 
                VALUES (?);
                """;

        try {
            var conn = sqlHandler.getConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement stmt = conn.prepareStatement(sqlPattern);
            stmt.setString(1, name);

            if (stmt.executeUpdate() == 0) {
                throw new SQLException("Insert failed, no rows affected");
            }

            var keys = stmt.getGeneratedKeys();
            if (!keys.next()) {
                conn.rollback();
                conn.setAutoCommit(true);
                return false;
            }

            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public Map<Artist, List<Album>> getArtistsAndAlbums() {
        Map<Artist, List<Album>> map = new HashMap<>();

        var sqlPattern = """
                SELECT art.ArtistId, art.Name, alb.Title, alb.AlbumId  
                FROM artists as art 
                inner join albums alb on art.ArtistId = alb.ArtistId;
                """;

        var rs = sqlHandler.executeQuery(sqlPattern);
        try {
            while (rs.next()) {
                String artistId = rs.getString("ArtistId");
                String name = rs.getString("Name");
                String albumId = rs.getString("AlbumId");
                String title = rs.getString("Title");

                Artist artist = new Artist(artistId, name);
                Album album = new Album(albumId, title, artistId);

                var albums = map.get(artist);
                if (albums != null ) {
                    albums.add(album);
                }
                else {
                    albums = new ArrayList<Album>();
                    albums.add(album);
                    map.put(artist, albums);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return map;
    }

    private int insertInvoice(User user, float total) {
        int invoiceId = 0;
        var sqlPattern = """
                INSERT INTO invoices (CustomerId, InvoiceDate, BillingAddress, BillingCity, 
                BillingState, BillingCountry, BillingPostalCode, Total) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?);
                """;

        var date = java.time.LocalDate.now();
        try {
            var conn = sqlHandler.getConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement stmt = conn.prepareStatement(sqlPattern);
            stmt.setString(1, user.getId());
            stmt.setObject(2, date);
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getCity());
            stmt.setString(5, user.getState());
            stmt.setString(6, user.getCountry());
            stmt.setString(7, user.getPostalCode());
            stmt.setFloat(8, total);

            if (stmt.executeUpdate() == 0) {
                throw new SQLException("Insert failed, no rows affected");
            }

            var keys = stmt.getGeneratedKeys();
            if (!keys.next()) {
                conn.rollback();
                conn.setAutoCommit(true);
                return -1;
            }

            invoiceId = stmt.getGeneratedKeys().getInt(1);

            conn.commit();
            conn.setAutoCommit(true);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return invoiceId;
    }

    private boolean insertInvoiceItems(Track track, int invoiceId, int quantity) {
        var sqlPattern = """
                INSERT INTO invoice_items (InvoiceId, TrackId, UnitPrice, Quantity) 
                VALUES (?, ?, ?, ?);
                """;

        try {
            var conn = sqlHandler.getConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement stmt = conn.prepareStatement(sqlPattern);
            stmt.setInt(1, invoiceId);
            stmt.setString(2, track.getTrackId());
            stmt.setFloat(3, track.getUnitPrice());
            stmt.setInt(4, quantity);

            if (stmt.executeUpdate() == 0) {
                throw new SQLException("Insert failed, no rows affected");
            }

            var keys = stmt.getGeneratedKeys();
            if (!keys.next()) {
                conn.rollback();
                conn.setAutoCommit(true);
                return false;
            }

            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
