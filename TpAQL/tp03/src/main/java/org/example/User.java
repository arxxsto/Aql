package org.example;

public class User {
    private String username;
    private String email;
    private long id;
    public User(long id, String username, String email) {
        this.email = email;
        this.username = username;
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public long getId() {
        return id;
    }
}

