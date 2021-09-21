package com.monash.MPMS;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Branch {
    public Branch() {
        this.branch = new ArrayList<Branch>();
    }

    /**
     * Method to load data base file
     */
    public void loadBranch() {
        // load file
        try {
            File branchFileObj = new file("Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine()) {
                String branchInformation = fileReader.nextLine();
                System.out.println(branchInformation);
            }
            fileReader.close();
        }
        catch (IOException e){
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
        searchBranchPC();
    }

    /**
     * Get User Input of Postcode
     */

    public void searchBranchPC() {
        System.out.println("Please enter the postcode of branch you are looking for...\n");
        Scanner sc = new Scanner(postcode);
        int postcode = sc.nextInt();
        // Error Handling
        boolean controller = false;
        if (!postcode.isEmpty()) {
            controller = true;
            return;
        }
        else {
            controller = false;
        }
        if(controller != true){
            System.out.println("Postcode can not be empty");
        }
        else {
            continue;
        }
    }

        // Find by postcode

    }

