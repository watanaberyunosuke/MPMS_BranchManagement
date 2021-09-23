package com.monash.MPMS;

import java.util.ArrayList;
import java.util.Scanner;

public class BranchManagementSystem {
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
        // init postcode variable
        String postcode;
        // Take user input
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(System.in);
        postcode = sc.nextLine();

        // Check if input matches pattern of postcode
        if(postcode.trim().matches("[0-9]+") && postcode.length() == 4) {
            System.out.println("The postcode is valid...Now loading database...");
        }
        else if(postcode.length() == 0){
            System.out.println("The postcode can not be empty...");
            searchBranchPC();
        }
        else if(postcode.length() < 4){
            System.out.println("The postcode you enter is too short...");
            searchBranchPC();
        }
        else{
            System.out.println("The postcode you have entered is not correct! \n Please check again.");
            searchBranchPC();
        }
        // Load Database
        Branch branchObj = new Branch();
        // Find all the index of clinic under the post code
        ArrayList<Integer> postcodeSearch = new ArrayList<>();
        postcodeSearch.add(0, 0);
        for(int i = 0; i < branchPostcode.size(); i++) {
            postcodeSearch.add(branchPostcode.indexOf(postcode));
        }

        // Find by postcode
        // Check if the value is contained
        boolean pcContains = branchPostcode.contains(postcode);
        ArrayList<Integer> branchIndex = new ArrayList<>();
        // Return clinic name by index
        if(pcContains){
            for(int i = 0; i < postcodeSearch.size(); i++){
                branchIndex.add(branchIndex.size()+1, branchPostcode.indexOf(postcode));
            }
            // Add required branch to new ArrayList
            ArrayList<String> searchResult = new ArrayList<>();
            for (int i=0; i < branchIndex.size(); i++){
                searchResult.add(branchName.get(i).toString());
            }

            System.out.println("The branch you are looking for is " );
            for(int i=0; i < searchResult.size(); i++){
                System.out.println(searchResult);
            }
            // Break For now
        }
        else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC(branchName, branchPostcode);
        }
    }

}

