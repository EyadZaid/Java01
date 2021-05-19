package com.training.experis.logic;

import com.training.experis.data.Album;
import com.training.experis.data.Track;
import com.training.experis.data.User;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbService implements IDbService {
    private final ISqlHandler sqlHandler;

    public DbService(ISqlHandler sqlHandler) {
        this.sqlHandler = sqlHandler;
    }

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
                int artistId = rs.getInt("ArtistId");
                Album album = new Album(id, title, artistId);
                albums.put(id, album);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return albums;
    }

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

            stmt.execute();
            invoiceId = stmt.getGeneratedKeys().getInt(1);

            conn.commit();
            conn.setAutoCommit(true);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return invoiceId;
    }

    private void insertInvoiceItems(Track track, int invoiceId, int quantity) {
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

            stmt.execute();
            conn.commit();
            conn.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
