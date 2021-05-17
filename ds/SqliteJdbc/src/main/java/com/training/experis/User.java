package com.training.experis;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private final String city;

    public User(int id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\nUser name: ");
        str.append(name);
        str.append("City: ");
        str.append(city);
        str.append("Email: ");
        str.append(email);
        str.append("\n");
        return str.toString();
    }
}
