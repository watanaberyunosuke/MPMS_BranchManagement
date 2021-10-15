package com.monash.MPMS;
import java.util.Scanner;

public class Login {
    private static int userClass;
    private static String password;
    private static String email;

    public Login() {
        userClass = 0;
        password = "";
        email = "";
    }

    static void startScreen()
    {
        System.out.println("************************");
        System.out.println("      Login Screen      ");
        System.out.println("************************");
        System.out.println("1. Log in");
        System.out.println("2. Exit to Main Menu");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option == 1)
        {
            loginScreen();
        }
        else if (option == 2)
        {
            System.out.println("Exiting System.");
        }
        else
        {
            System.out.println("Please select an option that is listed.");
        }
    }

    static void loginScreen()
    {
        Scanner newSc = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("    Login Screen");
        System.out.println("************************");
        System.out.println("Enter your email address:");
        String email;
        email = newSc.nextLine();
        System.out.println("Enter your email address: " + email);
        System.out.println("Enter your password:");
        String password;
        password = newSc.nextLine();
        System.out.println("Enter your password: " + password);
        if (email.equals("patient@monash.edu") && password.equals("Monash1234"))
        {
            userClass = 1;
        }
        else if (email.equals("admin@monash.edu") && password.equals("Monash1234"))
        {
            userClass = 2;
        }
        else
        {
            System.out.println("Sorry, email or password is incorrect. Please try again.");
        }
        homePage();
    }

    static void homePage()
    {
        if (userClass == 1)
        {
            patientLogin();
        }
        else if (userClass == 2)
        {
            adminLogin();
        }
        else
        {
            loginScreen();
        }
    }

    static void adminLogin()
    {
        System.out.println("************************");
        System.out.println("    Admin Home Page");
        System.out.println("************************");
        System.out.println("Please choose an option:");
        System.out.println("1. Clinic Management");
        System.out.println("2. GP Management");
        System.out.println("3. Status Dashboard");
        System.out.println("4. Log out");

        }

    static void patientLogin()
    {
        System.out.println("*************************");
        System.out.println("    Patient Home Page");
        System.out.println("*************************");
        System.out.println("1. Cancel Appointment.");
        System.out.println("2. Select favourite branch and GP.");
        System.out.println("3. Check details of a branch.");
        System.out.println("4. Book an Appointment.");
        System.out.println("5. Check in to Appointment.");
        System.out.println("6. Return to Login screen.");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option == 1)
        {
            System.out.println("Cancel Appointment");
        }
        else if (option == 2)
        {
            System.out.println("Select favourite branch and GP");
        }
        else if (option == 3)
        {
            System.out.println("Check details of branch");
            /* Branch.txt details goes here */
        }
        else if (option == 4)
        {
            Appointment myObj = new Appointment();
            Appointment.clinicSelection();
        }
        else if (option == 5)
        {
            System.out.println("Check in to an Appointment");
        }
        else if (option == 6)
        {
            System.out.println("Returning to login screen");
            startScreen();
        }
        else
        {
            System.out.println("Please select an option that is listed.");
            patientLogin();
        }
    }


    public static void main(String[] args)
    {
        startScreen();
    }
}

