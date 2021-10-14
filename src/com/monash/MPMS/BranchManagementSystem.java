package com.monash.MPMS;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BranchManagementSystem {
    public List<String> branchID = new ArrayList<>();
    public List<String> branchName = new ArrayList<>();
    public List<String> branchPC = new ArrayList<>();
    public List<String> branchAddress = new ArrayList<>();
    public List<String> branchOpenTime = new ArrayList<>();
    public List<String> branchPhone = new ArrayList<>();
    public List<String> GPID = new ArrayList<>();
    public List<String[]> GPName = new ArrayList<>();
    public List<String> GPBranch = new ArrayList<>();
    private final List<String> searchResults = new ArrayList<>();

    /**
     * Constructor
     */
    public BranchManagementSystem() {

    }

    /**
     * Method to load database file
     */
    public void loadBranch() {

        // load file with error handling
        try {
            File branchFileObj = new File("src/com/monash/MPMS/Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine()) {
                String branchInformation = fileReader.nextLine();
                String[] branchInfoArray = branchInformation.split(",", 6);
                if (branchInfoArray.length >= 6) {
                    branchID.add(branchInfoArray[0].trim());
                    branchName.add(branchInfoArray[1].trim());
                    branchPC.add(branchInfoArray[2].trim());
                    branchAddress.add(branchInfoArray[3].trim());
                    branchOpenTime.add(branchInfoArray[4].trim());
                    branchPhone.add(branchInfoArray[5].trim());
                }

            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    /**
     * Method to load database file
     *
     */
    public void loadGP() {

        // load file with error handling
        try {
            File GPFileObj = new File("src/com/monash/MPMS/GP.txt");
            Scanner fileReader = new Scanner(GPFileObj);
            while (fileReader.hasNextLine()) {
                String GPInformation = fileReader.nextLine();
                String[] GPInfoArray = GPInformation.split(",", 4);
                if (GPInfoArray.length >= 4) {
                    GPID.add(GPInfoArray[0].trim());
                    String[] GPNameArr = {GPInfoArray[1].trim(), GPInfoArray[2].trim()};
                    GPName.addAll(Collections.singleton(GPNameArr));
                    GPBranch.add(GPInfoArray[3].trim());
                }

            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    /**
     * Start of program logic
     */

    public void menu() {
        // Command Prompt
        loadBranch();
        System.out.println("**************************************************");
        System.out.println("      Welcome to the Branch Management System");
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
            case 1: {
                searchBranchPC();
                break;
            }
            case 2:{
                System.out.println("Case 2 ok");
                break;
            }
            case 3: {
                System.out.println("Thank you for using the system");
                System.exit(1);
            }
            default: {
                System.out.println("This is not an valid option...");
                menu();
            }
        }
    }

    /**
     * Get User Input of Postcode
     */

    public void searchBranchPC() {
        // Take user input
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(System.in);
        String postcodeEnter = sc.nextLine();

        // Check if input matches pattern of postcodeEnter
        if (postcodeEnter.trim().matches("[0-9]+") && postcodeEnter.length() == 4) {
            System.out.println("The postcode is valid...");
        } else if (postcodeEnter.length() == 0) {
            System.out.println("The postcode can not be empty...");
            searchBranchPC();
        }
        else if (postcodeEnter.length() < 4) {
            System.out.println("The postcode you enter is too short...");
            searchBranchPC();
        } else {
            System.out.println("The postcode you have entered is not correct! Please check again.");
            searchBranchPC();
        }


        // Find by postcode
        // Return clinic name by index
        // Create a new list to store search results
        List<Integer> searchIndex = new ArrayList<>();
        if (branchPC.contains(postcodeEnter)) {

            // Find index by postcode
            for (int i = 0; i < branchPC.size(); i++) {
                if (postcodeEnter.equals(branchPC.get(i))) {
                    searchIndex.add(i);
                }
            }
            // Find branches in the area
            for (Integer index : searchIndex) {
                searchResults.add(branchName.get(index));
            }


            searchResults.sort(String::compareToIgnoreCase);
            // Return result
            System.out.println("The following branches are in this area: ");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }

        } else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC();
        }

        // Select Branch to see detail
        System.out.println("Please select a branch to see it's detail");
        int userChoice = sc.nextInt();
        // Error handling
        if (userChoice > searchResults.size()) {
            System.out.println("There are not that many item in the result....");
        } else if (userChoice <= 0) {
            System.out.println("This number is too small...");
        }

        // Show branch information
        System.out.println("The information of this branch is as below");
        System.out.println("Branch ID: " + branchID.get(searchIndex.get(userChoice - 1)));
        System.out.println("Branch Name: " + branchName.get(searchIndex.get(userChoice - 1)));
        System.out.println("Postcode: " + branchPC.get(searchIndex.get(userChoice - 1)));
        System.out.println("Address: " + branchAddress.get(searchIndex.get(userChoice - 1)));
        System.out.println("Open Time: " + branchOpenTime.get(searchIndex.get(userChoice - 1)));
        System.out.println("Phone Number: " + branchPhone.get(searchIndex.get(userChoice - 1)));
        System.out.println("\nHere are a list of GPs in this branch");
        loadGP();
        List<Integer> GpLocateList = new ArrayList<>();
        List<String[]> GpOutList = new ArrayList<>();
        String targetBranchID = branchID.get(searchIndex.get(userChoice - 1));

        // Get list of GPs
        // Get GP's branch and check it against the target branch
        // Find index by branchID
        for (int i = 0; i < GPBranch.size(); i++) {
            if (GPBranch.get(i).equals(targetBranchID)) {
                GpLocateList.add(i);
            }
        }
        // Find GP in this branch
        for (Integer i : GpLocateList) {
            GpOutList.add(GPName.get(i));
        }

        // Print out
        if (GpLocateList.size() > 0) {
            for (int i = 0; i < GpLocateList.size(); i++) {
                System.out.println((i + 1) + ". " + GpOutList.get(i)[0] + " " + GpOutList.get(i)[1]);
            }
        } else {
            System.out.println("There are no GP in this branch.");
        }

        // Select a doctor
        System.out.println("Please select a doctor to make appointment, enter 0 for a random doctor");
        int chooseGP = sc.nextInt();
        int GPDecision = 0;
        Random randomNo = new Random();
        if (chooseGP == 0) {
            GPDecision = randomNo.nextInt(GpLocateList.size());
        } else {
            GPDecision = chooseGP;
        }

        // Pass GP Value to appointment management system
        // TODO: Integration with appointment management system

    }
}


