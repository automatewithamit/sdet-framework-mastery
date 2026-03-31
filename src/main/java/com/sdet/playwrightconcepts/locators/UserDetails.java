package com.sdet.playwrightconcepts.locators;

public class UserDetails {

    String userRole;
    String empName;
    String status;
    String username;
    String password;

    public UserDetails(){

    }

    public String getUserRole() {

        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmpName() {

        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
