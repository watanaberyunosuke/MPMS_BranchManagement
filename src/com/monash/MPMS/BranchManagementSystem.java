package com.monash.MPMS;

import java.util.Scanner;

public class BranchManagementSystem {
    public BranchManagementSystem() {
        int userInput;
    }

    private void menu() {
        // Command Prompt
        System.out.println("**************************************************");
        System.out.println("Welcome to the Branch Management System");
        System.out.println("**************************************************");
        System.out.println("Please choose an option");
        System.out.println("1. Search Branch by Postcode");
        System.out.println("2. Search Branch by GP");
        System.out.println("3. Quit");
        // Scanner
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        // Switch case to the dedicated methods
        switch (input) {
            case 1:
                new Branch().loadBranch();
                break;
            case 2:
                new Login().selectUserClass();
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
}
