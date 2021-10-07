package com.monash.MPMS;

import java.util.*;

public class BranchManagementSystem {
    // TODO: Consider changing data structure, use hashMap or hashTable
    //TODO 2: Change visualbility and lifetime of var: postcodeSearch
    private final List<Branch> branchList = new ArrayList<Branch>();
    private final List<GP> gpList = new ArrayList<GP>();
    private String[] postcodeSearch;



    public BranchManagementSystem() {

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
     * @param branchObj
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
            Branch branch = new Branch();
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
        occurrence = Collections.frequency((Collection<?>) branchObj, postcodeEnter);
        if(occurrence > 0){
            // Find index of all matching branches using lambda function stream
            // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
            String[] postcodeSearch = (String[]) branchList.stream()
                    .filter(searchID -> (Branch.getBranchPostcode()).equals(searchID) || Branch.getBranchPostcode().equals(postcodeEnter))
                    .toArray();
            // Return result
            System.out.println("The following branches are in this area: ");
            for(int i = 0; i < postcodeSearch.length;i++){
                System.out.println((i+1) + ". " + postcodeSearch[i]);
                this.postcodeSearch = postcodeSearch;
            }

        }
        else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC(branchObj);
        }
        
        // Select Branch to see detail
        System.out.println("Please select a branch to see it's detail");
        int userChoice = sc.nextInt();
        // Error handling
        if(userChoice > postcodeSearch.length){
            System.out.println("There are not that many item in the result....");
        }
        else if(userChoice <= 0){
            System.out.println("This number is too small...");
        }
        else{
            // target
            return;
        }

    }


}

