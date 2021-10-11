package com.monash.MPMS;

import java.util.Scanner;

public class Login {
    /**
     * Constructor
     */
    public Login() {
        int userClass;
    }

    /**
     * Login Method
     */

    public void login() {
        // Console prompt
        System.out.println("Welcome");
        // Select respective user classes
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        System.out.println("Please enter your email: /n");
        String email = sc.nextLine();
        System.out.println("Email is: " + email);
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        System.out.println("Password: " + password);

        // Checking email
        // TODO: change check credential to: load from txt file.
        if (email.equals("admin@monash.edu") && password.equals("Monash1234")) {
            adminHome();
        } else if (email.equals("patient@monash.edu") && password.equals("Monash1234")) {
            patientHome();
        } else {
            System.out.println("The credential you have entered is not correct...");
            login();
        }

    }

    /**
     * Patient Home Page
     */

    public void patientHome() {
        System.out.println("Welcome to patient homepage");

    }

    /**
     * Admin Home Page
     */

    public void adminHome() {
        System.out.println("Welcome to admin homepage");

    }
}
