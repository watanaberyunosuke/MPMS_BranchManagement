package com.monash.MPMS;

import java.util.Scanner;

public class Console {
    /**
     * Console Method
     */

    public void start()
    {
        // Command Prompt
        System.out.println("**************************************************");
        System.out.println("Welcome to the Monash Patient Management System");
        System.out.println("**************************************************");
        System.out.println("Please choose an option");
        System.out.println("1. Create a user");
        System.out.println("2. Login as an existing user");
        System.out.println("3. Quit");

        // Scanner
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        // Switch case to the dedicated methods
        switch (input) {
            case 1:
                new User().createUser();
                break;
            case 2:
                new Login().login();
                break;
            case 3:
                System.out.println("Thank you for using the system");
                System.exit(1);
                break;
            default:
                System.out.println("This is not an valid option...");
                break;
        }
    }
}
