package com.training.experis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id = scanner.nextInt();

        User user = getUserById(id);
        if (user != null) {
            System.out.println(user);
        }

        System.out.println(getAlbumsByArtistName("police"));

        System.out.println(getAllTracksByAlbumId(215));


    }

    public static Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";

        Connection conn = DriverManager.getConnection(url + dbFile);

        System.out.println("Connection to SQLite has been established.");
        return conn;
    }

    public static User getUserById(int id) {
        User user = null;
        String sql = "SELECT FirstName, City, Email FROM customers" +
                " where CustomerId = " + id;

        try (var conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String name = rs.getString("FirstName");
                String city = rs.getString("City");
                String email = rs.getString("Email");
                user = new User(id, name, email, city);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static List<Album> getAllAlbumsByArtistId(int artistId) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT AlbumId, Title, ArtistId FROM albums " +
                "where ArtistId = " + artistId;

        try (var conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("AlbumId");
                String title = rs.getString("Title");
                Album album = new Album(id, title, artistId);
                albums.add(album);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return albums;
    }

    public static List<Track> getAllTracksByAlbumId(int albumId) {
        List<Track> tracks = new ArrayList<>();
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
                float unitPrice = rs.getInt("UnitPrice");

                Track track = new Track(id, name, albumId, mediaTypeId, genreId, composer,
                        milliseconds, bytes, unitPrice);
                tracks.add(track);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tracks;
    }

    public static void createInvoice() {
        String sql = "INSERT INTO invoices (CustomerId, InvoiceDate, BillingAddress, BillingCity, " +
                "BillingState, BillingCountry, BillingPostalCode, Total) " +
                "VALUES (5, '', 'aaa', 'bbb', 'ccc', 'ddd', 'eee', 0.99);";

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

    public static List<Album> getAlbumsByArtistName(String artistName) {
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


}
