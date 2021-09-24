package com.monash.MPMS;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Start of class
 */

public class Branch{
    private final int branchId;
    private String branchName;
    private String branchPostcode;
    private final List<String> branchNameList = new ArrayList<>();
    private final List<String> branchPostcodeList = new ArrayList<>();

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
     * @param branchId: Int of id of branch
     * @param branchName: String() name of branch
     * @param branchPostcode: String() the postcode of branch
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
        // init postcodeEnter variable
        String postcodeEnter;
        // Take user input
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(System.in);
        postcodeEnter = sc.nextLine();

        // Check if input matches pattern of postcodeEnter
        if(postcodeEnter.trim().matches("[0-9]+") && postcodeEnter.length() == 4) {
            System.out.println("The postcode is valid...Now loading database...");
            loadBranch();
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
            System.out.println("The postcode you have entered is not correct! Please check again.");
            searchBranchPC();
        }


        // Find by postcode
        // Return clinic name by index
        // TODO: Change iteration from adding to iterating to check
        // Count occurrence of postcode entered
        int occurrence;
        occurrence = Collections.frequency(branchPostcodeList, postcodeEnter);
        if(occurrence > 0){
            // Find index of all matching branches
            // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
            int[] postcodeSearchIndex = IntStream.range(0, branchPostcodeList.size())
                    .filter(i -> postcodeEnter.equals(branchPostcodeList.get(i)))
                    .toArray();
            // Return result
            List<String> postcodeSearchResults = new ArrayList<>();
            for (int searchIndex : postcodeSearchIndex) {
                String output = branchNameList.get(searchIndex);
                postcodeSearchResults.add(output.trim());
            }
            System.out.println("The following branches are in this area: ");
            for(int i = 0; i < postcodeSearchResults.size();i++){
                System.out.println((i+1) + ". " + postcodeSearchResults.get(i));
            }

        }
        else {
            System.out.println("We can not find the branch that you are looking for...");
            searchBranchPC();
        }
    }


}

