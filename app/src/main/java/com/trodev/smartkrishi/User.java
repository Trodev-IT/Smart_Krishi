package com.trodev.smartkrishi;

public class User {
    public String usersname, email, division, age, number, password;

    public User() {

    }

    public User(String usersname, String email, String division, String age, String number, String password) {
        this.usersname = usersname;
        this.email = email;
        this.division = division;
        this.age = age;
        this.number = number;
        this.password = password;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
