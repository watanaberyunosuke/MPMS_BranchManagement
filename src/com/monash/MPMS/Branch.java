package com.monash.MPMS;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Branch {
    private final List<String> branchID = new ArrayList<>();
    private final List<String> branchName = new ArrayList<>();
    private final List<String> branchPC = new ArrayList<>();
    private final List<String> branchAddress = new ArrayList<>();
    private final List<String> branchOpeningHours = new ArrayList<>();
    private static final List<String> branchPhone = new ArrayList<>();
    private static String selectedBranch;

    public Branch() {
        selectedBranch = "";

    }

    private void loadBranch() {
        // load file with error handling
        try {
            File branchFileObj = new File("src/com/monash/MPMS/Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine()) {
                String branchInformation = fileReader.nextLine();
                String[] branchInfoArray = branchInformation.split(",", 6);
                if (branchInfoArray.length >= 5) {
                    branchID.add(branchInfoArray[0].trim());
                    branchName.add(branchInfoArray[1].trim());
                    branchPC.add(branchInfoArray[2].trim());
                    branchAddress.add(branchInfoArray[3].trim());
                    branchOpeningHours.add(branchInfoArray[4].trim());
                    branchPhone.add(branchInfoArray[5].trim());
                }
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    public void clinicSelection() {
        loadBranch();
        System.out.println("****************************");
        System.out.println("     Check Clinic Details   ");
        System.out.println("****************************");
        System.out.println("Please select a Clinic:");
        int userChoice = 1;
        for (String element : branchName) {
            System.out.println(userChoice + ". " + element);
            userChoice = userChoice + 1;
        }
        System.out.println(userChoice + ". To return to Patient Home Page.");
        Scanner newSc = new Scanner(System.in);
        int option = newSc.nextInt();
        if (option > userChoice) {
            System.out.println("Please select a number that's listed.");
            clinicSelection();
        } else if (option == userChoice) {
            System.out.println("Returning to patient home page.");
        } else {
            option = option - 1;
            selectedBranch = branchName.get(option);
            System.out.println(selectedBranch);
            // Show branch information
            System.out.println("The information of this branch is as below");
            System.out.println("Branch ID: " + branchID.get(option));
            System.out.println("Branch Name: " + branchName.get(option));
            System.out.println("Postcode: " + branchPC.get(option));
            System.out.println("Address: " + branchAddress.get(option));
            System.out.println("Open Time: " + branchOpeningHours.get(option));
            System.out.println("Phone Number: " + branchPhone.get(option));
            returnToPage();
        }
    }

    public void returnToPage() {
        System.out.println("1. Search for another Branch.");
        System.out.println("2. Return to Patient Home Page.");
        int option;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option == 2) {
            Login.patientLogin();
        } else if (option == 1) {
            clinicSelection();
        } else {
            System.out.println("Please select a listed option.");
            returnToPage();
        }
    }


}


