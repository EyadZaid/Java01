package com.experis.springrestapi.entities;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String city;
    private final String address;
    private final String state;
    private final String country;
    private final String postalCode;

    public User(String id, String name, String email, String city, String address, String state,
                String country, String postalCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.address = address;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("User name: ");
        str.append(name);
        str.append("\nCity: ");
        str.append(city);
        str.append("\nEmail: ");
        str.append(email);
        return str.toString();
    }
}
