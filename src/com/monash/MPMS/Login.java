package com.monash.MPMS;
import java.util.Scanner;

public class Login {
    static int userClass;

    public Login() {
        userClass = 0;
    }

    public static void patientLogin()
    {
        if (userClass == 1) {


        }


    }

    public static void main(String[] args)
    {
        int userClass;
        Scanner newSc = new Scanner(System.in);
        System.out.println("Please enter your email.");
        String email;
        email = newSc.nextLine();
        System.out.println("Email is: " + email);
        System.out.println("Please enter your password");
        String password;
        password = newSc.nextLine();
        System.out.println("Password: " + password);
        if (email.equals("patient@monash.edu") && password.equals("Monash1234"))
        {
            System.out.println("Welcome patient.");
            userClass = 1;
        }
        else if (email.equals("admin@monash.edu") && password.equals("Monash1234"))
        {
            System.out.println("Welcome admin.");
            userClass = 2;
        }
        else
        {
            System.out.println("Sorry, email or password is incorrect. Please try again.");
        }
        patientLogin();
    }
}

