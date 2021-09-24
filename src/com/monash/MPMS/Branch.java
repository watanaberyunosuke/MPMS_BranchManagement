package com.monash.MPMS;

import java.io.*;
import java.util.*;

public class Branch{
    private final int branchId;
    private String branchName;
    private String branchPostcode;
    private ArrayList<String> branchNameList = new ArrayList<>();
    private ArrayList<String> branchPostcodeList = new ArrayList<>();

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

        // load file
        try {
            File branchFileObj = new File("src/com/monash/MPMS/Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine()) {
                String branchInformation = fileReader.nextLine();
                String[] branchInfoArray = branchInformation.split(",", 3);
                if(branchInfoArray.length >= 2){
                    branchNameList.add(branchInfoArray[1]);
                    branchPostcodeList.add(branchInfoArray[2].trim());
                }

            }
            fileReader.close();
        }
        catch (IOException e) {
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
        loadBranch();
        // init postcodeEnter variable
        String postcodeEnter;
        // Take user input
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(System.in);
        postcodeEnter = sc.nextLine();

        // Check if input matches pattern of postcodeEnter
        if(postcodeEnter.trim().matches("[0-9]+") && postcodeEnter.length() == 4) {
            System.out.println("The postcode is valid...Now loading database...");
        }
        else if(postcodeEnter.length() == 0){
            System.out.println("The postcode can not be empty...");
            searchBranchPC();
        }
        else if(postcodeEnter.length() < 4){
            System.out.println("The postcode you enter is too short...");
            searchBranchPC();
        }
        else{
            System.out.println("The postcode you have entered is not correct! \nPlease check again.");
            searchBranchPC();
        }

        // Find all the index of clinic under the post code
        ArrayList<Integer> postcodeSearch = new ArrayList<>();
        postcodeSearch.add(0, 0);
        for(int i = 0; i < branchPostcodeList.size(); i++) {
            postcodeSearch.add(branchPostcodeList.indexOf(postcodeEnter));
        }

        // Find by postcode
        ArrayList<Integer> branchIndex = new ArrayList<>();
        // Return clinic name by index
        // TODO: Change iteration from adding to iterating to check
        // Count occurrence of postcode entered
        int occurrence = Collections.frequency(branchPostcodeList, postcodeEnter);
        if(occurrence > 0){
            for(int i = 0;i < occurrence; i++){
                branchIndex.add(i, branchPostcodeList.indexOf(postcodeEnter));
            }
            // Add required branch to new ArrayList
            ArrayList<String> searchResult = new ArrayList<>();
            for (int i = 0; i < occurrence; i++) {
                String result = branchNameList.get(branchIndex.get(i)).trim();
                searchResult.add(result);
            }

            // Print out result
            System.out.println("The branch you are looking for is " );
            System.out.println(searchResult);
            // Break For now
        }
        else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC();
        }
    }


}

