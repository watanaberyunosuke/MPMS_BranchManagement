package com.monash.MPMS;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BranchManagementSystem {
    // TODO: Consider changing data structure, use hashMap or hashTable
    // TODO 2: Change visibility and lifetime of var: postcodeSearch
    public List<String> branchNameList = new ArrayList<>();
    public List<String> branchPCList = new ArrayList<>();
    private String[] postcodeSearch;


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
                String[] branchInfoArray = branchInformation.split(",", 3);
                if (branchInfoArray.length >= 2) {
                    branchNameList.add(branchInfoArray[1]);
                    branchPCList.add(branchInfoArray[2].trim());
                }

            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    public void menu() {
        // Command Prompt
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
                Branch branchObj = new Branch();
                searchBranchPC(branchObj);
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
     * @param branchObj: object of branch object
     */

    public void searchBranchPC(Branch branchObj) {
        // init postcodeEnter variable
        String postcodeEnter;
        // Take user input
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(System.in);
        postcodeEnter = sc.nextLine();

        // Check if input matches pattern of postcodeEnter
        if(postcodeEnter.trim().matches("[0-9]+") && postcodeEnter.length() == 4) {
            System.out.println("The postcode is valid...");
        }
        else if(postcodeEnter.length() == 0){
            System.out.println("The postcode can not be empty...");
            searchBranchPC(branchObj);
        }
        else if(postcodeEnter.length() < 4){
            System.out.println("The postcode you enter is too short...");
            searchBranchPC(branchObj);
        }
        else{
            System.out.println("The postcode you have entered is not correct! Please check again.");
            searchBranchPC(branchObj);
        }


        // Find by postcode
        // Return clinic name by index
        // Count occurrence of postcode entered

        int occurrence;
        occurrence = Collections.frequency((Collection<?>) branchPCList, postcodeEnter);
        if(occurrence > 0) {
            // Find index of all matching branches using lambda function stream
            // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
            String[] postcodeSearch = (String[]) branchPCList.stream()
                    .filter(searchID -> (branchPCList.get().equals(postcodeEnter)))
                    .toArray();
            // Return result
            System.out.println("The following branches are in this area: ");
            for (int i = 0; i < postcodeSearch.length; i++) {
                System.out.println((i + 1) + ". " + postcodeSearch[i]);
                this.postcodeSearch = postcodeSearch;
            }

        } else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC(branchObj);
        }

        // Select Branch to see detail
        System.out.println("Please select a branch to see it's detail");
        int userChoice = sc.nextInt();
        // Error handling
        if (userChoice > postcodeSearch.length) {
            System.out.println("There are not that many item in the result....");
        } else if (userChoice <= 0) {
            System.out.println("This number is too small...");
        }


    }


}

