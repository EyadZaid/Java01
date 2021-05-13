package com.training.experis;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        selectAll();
    }

    public static Connection connect() throws SQLException {
        var url = "jdbc:sqlite:";
        var dbFile = "src\\main\\resources\\chinook.db";

        Connection conn = DriverManager.getConnection(url+dbFile);

        System.out.println("Connection to SQLite has been established.");
        return conn;
    }

    public static void selectAll() {
        String sql = "SELECT name,  artistid FROM artists";

        try (var conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("ArtistId") + "\t" + rs.getString("name")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
