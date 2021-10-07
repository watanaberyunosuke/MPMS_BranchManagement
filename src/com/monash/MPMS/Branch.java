package com.monash.MPMS;

import java.io.*;
import java.util.*;

/**
 * Start of class
 */

public class Branch {
    String branchId;
    String branchName;
    String branchPostcode;
    private final List<String> branchNameList = new ArrayList<>();
    private final List<String> branchPostcodeList = new ArrayList<>();

    /**
     * Default Constructor
     */

    public Branch() {
        branchId = "";
        branchName = "";
        branchPostcode = "";
    }

    /**
     * Parameterised constructor
     *
     * @param branchId:       Int of id of branch
     * @param branchName:     String() name of branch
     * @param branchPostcode: String() the postcode of branch
     */

    public Branch(String branchId, String branchName, String branchPostcode) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchPostcode = branchPostcode;
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
                    branchPostcodeList.add(branchInfoArray[2].trim());
                }

            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

        /**
         * Mutator
         */

        public void setBranchName () {
            this.branchName = branchName;
        }

        public void setBranchPostcode () {
            this.branchPostcode = branchPostcode;
        }

        /**
         * Accessor and Mutator
         */

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getBranchPostcode() {
            return branchPostcode;
        }

        public void setBranchPostcode(String branchPostcode) {
            this.branchPostcode = branchPostcode;
        }
}

