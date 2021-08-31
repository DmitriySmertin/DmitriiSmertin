package com.epam.jdi.enteties;

public class User {

    public final static User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    String name;
    String password;
    String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
