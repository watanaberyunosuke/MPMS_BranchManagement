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
        System.out.println("************************");
        System.out.println("    Patient Home Page");
        System.out.println("************************");
        System.out.println("1. Cancel Appointment.");
        System.out.println("2. Select favourite branch and GP.");
        System.out.println("3. Check details of a branch.");
        System.out.println("4. Book an Appointment.");
        System.out.println("5. Check in to Appointment.");
        System.out.println("Esc. back to Branch Locator.");
    }


    public static void main(String[] args)
    {
        loginScreen();
    }
}

