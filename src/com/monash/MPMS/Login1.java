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

    public void selectUserClass() {
        System.out.println("Welcome");
        System.out.println("Please Select Your User Group");
        System.out.println("1. Patient");
        System.out.println("2. Admin");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput){
            case 1:
                patientHome();
            case 2:
                adminHome();
            default:
                System.out.println("This is not an valid option");
                selectUserClass();
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
