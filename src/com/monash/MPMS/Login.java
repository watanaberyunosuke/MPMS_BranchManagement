package com.monash.MPMS;
import java.util.Scanner;

public class Login {
    private static int userClass;
    private static String password;
    private static String email;

    public Login() {
        /**
         * Constructor for Login class
         */
        userClass = 0;
        password = "";
        email = "";
    }

    static void startScreen()
    {
        /**
         * Display the initial login screen
         */
        System.out.println("************************");
        System.out.println("      Login Screen      ");
        System.out.println("************************");
        System.out.println("1. Log in");
        System.out.println("2. Exit");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option == 1) //user wants to login
        {
            loginScreen();
        }
        else if (option == 2) //user wants to exit the system
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
        /**
         * Display the screen that the user can log in from.
         */
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
        if (email.equals("patient@monash.edu") && password.equals("Monash1234")) //check that email and password match what's in the system
        {
            userClass = 1; //if user is considered a patient
        }
        else if (email.equals("admin@monash.edu") && password.equals("Monash1234"))
        {
            userClass = 2; //if user is considered an admin
        }
        else
        {
            System.out.println("Sorry, email or password is incorrect. Please try again.");
        }
        homePage();
    }

    static void homePage()

    {
        /**
         * method that decides whether to take the user to the patient home page or admin home page
         */
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
        /**
         * Method that displays the admin home page
         */
        System.out.println("************************");
        System.out.println("    Admin Home Page");
        System.out.println("************************");
        System.out.println("Please choose an option:");
        System.out.println("1. Clinic Management");
        System.out.println("2. GP Management");
        System.out.println("3. Status Dashboard");
        System.out.println("4. Log out");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option == 1)
        {
            System.out.println("Clinic Management");
        }
        else if (option == 2)
        {
            System.out.println("GP Management");
        }
        else if (option == 3)
        {
            Report rptObj = new Report();
            rptObj.generateReport();
        }
        else if (option == 4)
        {
            System.out.println("Returning to login screen");
            startScreen();
        }
        else
        {
            System.out.println("Please select an option that is listed.");
            adminLogin();
        }
    }

    static void patientLogin()
    {
        /**
         * Method that displays the patient home page.
         */
        System.out.println("*************************");
        System.out.println("    Patient Home Page");
        System.out.println("*************************");
        System.out.println("1. Cancel Appointment (not completed).");
        System.out.println("2. Select favourite branch and GP (not completed).");
        System.out.println("3. Check details of a branch.");
        System.out.println("4. Book an Appointment.");
        System.out.println("5. Check in to Appointment. (not completed)");
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
            Branch myObj = new Branch();
            myObj.clinicSelection();
        }
        else if (option == 4)
        {
            Appointment myObj = new Appointment();
            myObj.clinicSelection();
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

