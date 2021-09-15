/**
 * Import packages
 */

package com.monash.MPMS;
import java.util.*;

/**
 * Main class
 */

public class Main {

    /**
     * Main method
     * @param args
     */

    public static void main(String[] args) {
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
                createUser();
                break;
            case 2:
                login();
                break;
            case 3:
                quit();
                break;
            default:
                System.out.println("This is not an valid option...");
                break;
        }

    }

    /**
     * Method to create user
     */

    private void createUser() {
        System.out.println("Create User");
    }

    /**
     * Login Method
     */

    private void login() {
        System.out.println("Welcome");
        System.out.println("Please Select Your User Group");
        System.out.println("1. Patient");
        System.out.println("2. Admin");

    }

    private void quit() {
        System.out.println("Thank you for using the system");
        System.exit(1);
    }
}
