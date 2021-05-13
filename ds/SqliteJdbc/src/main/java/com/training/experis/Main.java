package com.training.experis;

import java.sql.*;
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
}
