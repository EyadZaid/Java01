package com.training.experis.logic;

import com.training.experis.data.Album;
import com.training.experis.data.Track;
import com.training.experis.data.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbService implements IService {
    private final ISqlHandler sqlHandler;

    public DbService(ISqlHandler sqlHandler) {
        this.sqlHandler = sqlHandler;
    }

    public User getUserById(int userId) {
        User user = null;

        var sqlPattern = """
                SELECT FirstName, Email, City, Address, State, Country, PostalCode FROM customers 
                where CustomerId = %d;
                """;

        var sql = String.format(sqlPattern, userId);

        try (var conn = sqlHandler.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("FirstName");
                String city = rs.getString("City");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String state = rs.getString("State");
                String country = rs.getString("Country");
                String postalCode = rs.getString("PostalCode");
                user = new User(userId, name, email, city, address, state, country, postalCode);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public List<Album> getAlbumsByArtistName(String artistName) {
        List<Album> albums = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT alb.AlbumId, alb.Title, alb.ArtistId FROM artists as art ");
        sql.append("inner join albums alb on art.ArtistId = alb.ArtistId WHERE art.NAME LIKE '%");
        sql.append(artistName);
        sql.append("%';");

        try (var conn = sqlHandler.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            while (rs.next()) {
                int id = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                int artistId = rs.getInt("ArtistId");
                Album album = new Album(id, title, artistId);
                albums.add(album);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return albums;
    }

    public Map<Integer, Track> getAllTracksByAlbumId(int albumId) {
        Map<Integer, Track> tracks = new HashMap<>();

        var sqlPattern = """
                SELECT * FROM tracks 
                WHERE AlbumId = %d;
                """;

        var sql = String.format(sqlPattern, albumId);

        try (var conn = sqlHandler.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("TrackId");
                String name = rs.getString("Name");
                int mediaTypeId = rs.getInt("MediaTypeId");
                int genreId = rs.getInt("GenreId");
                String composer = rs.getString("Composer");
                int milliseconds = rs.getInt("Milliseconds");
                int bytes = rs.getInt("Bytes");
                float unitPrice = rs.getFloat("UnitPrice");

                Track track = new Track(id, name, albumId, mediaTypeId, genreId, composer,
                        milliseconds, bytes, unitPrice);
                tracks.put(id, track);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tracks;
    }





    public void createInvoice(User user, Track track, int quantity) {
        float total = quantity * track.getUnitPrice();
        int invoiceId = insertInvoice(user, total);
        insertInvoiceItems(track, invoiceId, quantity);
    }

    private int insertInvoice(User user, float total) {
        int invoiceId = 0;
        var sqlPattern = """
                INSERT INTO invoices (CustomerId, InvoiceDate, BillingAddress, BillingCity, 
                BillingState, BillingCountry, BillingPostalCode, Total) 
                VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', %f);
                """;

        var date = java.time.LocalDate.now();
        var sql = String.format(sqlPattern, user.getId(), date, user.getAddress(), user.getCity(),
                user.getState(), user.getCountry(), user.getPostalCode(), total);

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = sqlHandler.connect();
            stmt = conn.createStatement();
            stmt.execute(sql);
            invoiceId = stmt.getGeneratedKeys().getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return invoiceId;
    }

    private void insertInvoiceItems(Track track, int invoiceId, int quantity) {
        var sqlPattern = """
                INSERT INTO invoice_items (InvoiceId, TrackId, UnitPrice, Quantity) 
                VALUES (%d, %d, %f, %d);
                """;

        var sql = String.format(sqlPattern, invoiceId, track.getTrackId(),
                track.getUnitPrice(), quantity);

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = sqlHandler.connect();
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
