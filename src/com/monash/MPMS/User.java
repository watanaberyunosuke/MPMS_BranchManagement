package com.monash.MPMS;

public class User {
    private static String userPassword;
    private static String userEmail;

    public User()
    {
        userPassword = "";
        userEmail = "";

    }
    public String getPassword()
    {
        return userPassword;
    }

    public void setPassword(String password)
    {
       this.userPassword = password;
    }

    public String getEmail()
    {
        return userEmail;
    }

    public void setEmail(String email)
    {
        this.userEmail = email;
    }
    public static void main(String[] args)
    {

    }
}
