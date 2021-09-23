package com.monash.MPMS;

import java.io.*;
import java.util.*;

public class Branch implements Serializable{
    private int branchId;
    private String branchName;
    private String branchPostcode;

    /**
     * Default Constructor
     */

    public Branch() {
        branchId = 0;
        branchName = "";
        branchPostcode = "";
    }

    /**
     * Parameterised constructor
     * @param branchId
     * @param branchName
     * @param branchPostcode
     */

    public Branch(int branchId, String branchName,String branchPostcode){
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchPostcode = branchPostcode;
    }

    /**
     * Method to load database file
     */
    public void loadBranch() {
        ArrayList<String> branchName = new ArrayList<>();
        ArrayList<String> branchPostcode = new ArrayList<>();

        // load file
        try {
            File branchFileObj = new File("src/com/monash/MPMS/Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine()) {
                String branchInformation = fileReader.nextLine();
                String[] branchInfoArray = branchInformation.split(",", 3);
                if(branchInfoArray.length >= 2){
                    branchName.add(branchInfoArray[1]);
                    branchPostcode.add(branchInfoArray[2].trim());
                }

            }
            fileReader.close();
        }
        catch (IOException e){
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    /**
     * Mutator
     */

    public void setBranchName(){
        this.branchName = branchName;
    }

    public void setBranchPostcode(){
        this.branchPostcode = branchPostcode;
    }

    /**
     * Accessor
     */

    public String getBranchName(){
        return this.branchName;
    }

    public Integer getBranchId(){
        return this.branchId;
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

