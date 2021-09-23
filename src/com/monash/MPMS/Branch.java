package com.monash.MPMS;

import java.io.*;
import java.util.*;

public class Branch {

    /**
     * Default Constructor
     */

    public Branch() {

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



}

