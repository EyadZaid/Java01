package com.training.experis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id");

        String id = scanner.nextLine();
        User user = getUserById(id);
        if (user != null) {
            System.out.println(user);
        }

        System.out.println(getAllAlbumsByArtistId("1"));

    }

    public static Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";

        Connection conn = DriverManager.getConnection(url + dbFile);

        System.out.println("Connection to SQLite has been established.");
        return conn;
    }

    public static User getUserById(String id) {
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


    public static List<Album> getAllAlbumsByArtistId(String artistId) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT AlbumId, Title, ArtistId FROM albums " +
                "where ArtistId = " + artistId;

        try (var conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("AlbumId");
                String title = rs.getString("Title");
                Album album = new Album(id, title, artistId);
                albums.add(album);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return albums;
    }
}
