package com.training.experis;

import java.sql.*;
import java.util.*;

public class SqlJdbc {

    public void run () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your id: ");
        int userId = scanner.nextInt();

        User user = getUserById(userId);
        if (user != null) {
            System.out.println(user);
        }

        scanner.nextLine();
        System.out.println("\nEnter artist name: ");
        String artistName = scanner.nextLine();
        System.out.println(getAlbumsByArtistName(artistName));

        System.out.println("\nEnter album id: ");
        int albumId = scanner.nextInt();
        Map<Integer, Track> tracks = getAllTracksByAlbumId(albumId);
        System.out.println(tracks);

        System.out.println("\nEnter track id: ");
        int trackId = scanner.nextInt();

        Track track = tracks.get(trackId);
        createInvoice(user, track, 1);
    }

    private Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";
        Connection conn = DriverManager.getConnection(url + dbFile);
        return conn;
    }

    private User getUserById(int id) {
        User user = null;
        String sql = "SELECT FirstName, Email, City, Address, State, Country, " +
                "PostalCode FROM customers" +
                " where CustomerId = " + id;

        try (var conn = connect();
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
                user = new User(id, name, email, city, address, state, country, postalCode);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private List<Album> getAlbumsByArtistName(String artistName) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT alb.AlbumId, alb.Title, alb.ArtistId FROM artists as art inner join albums alb on art.ArtistId = alb.ArtistId " +
                "WHERE art.NAME LIKE '%" + artistName + "%';";

        try (var conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    private Map<Integer, Track> getAllTracksByAlbumId(int albumId) {
        Map<Integer, Track> tracks = new HashMap<>();
        String sql = "SELECT * FROM tracks " +
                "where AlbumId = " + albumId;

        try (var conn = connect();
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

    private void createInvoice(User user, Track track, int quantity) {
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
            conn = connect();
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
            conn = connect();
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
