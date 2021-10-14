package com.monash.MPMS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;
import java.io.*;

<<<<<<< HEAD
public class BranchManagementSystem {
    // TODO: Consider changing data structure, use hashMap or hashTable
    // TODO 2: Change visibility and lifetime of var: postcodeSearch
    public List<String> branchID = new ArrayList<>();
    public List<String> branchName = new ArrayList<>();
    public List<String> branchPC = new ArrayList<>();
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
                String[] branchInfoArray = branchInformation.split(",", 3);
                if (branchInfoArray.length >= 2) {
                    branchID.add(branchInfoArray[0].trim());
                    branchName.add(branchInfoArray[1].trim());
                    branchPC.add(branchInfoArray[2].trim());
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
     * TODO: Finish this method
     */
    public void loadGP() {

        // load file with error handling
        try {
            File GPFileObj = new File("src/com/monash/MPMS/GP.txt");
            Scanner fileReader = new Scanner(GPFileObj);
            while (fileReader.hasNextLine()) {
                String GPInformation = fileReader.nextLine();
                String[] GPInfoArray = GPInformation.split(",", 4);
                if (GPInfoArray.length >= 3) {
                    GPID.add(GPInfoArray[0].trim());
                    String[] GPNameArr = {GPInfoArray[1].trim(), GPInfoArray[2].trim()};
                    GPName.addAll(Collections.singleton(GPNameArr));
                    GPBranch.add(GPInfoArray[3]);
                }
=======
public class BranchManagement {
    final static String filePath = "src/com/monash/MPMS/BranchAddress";

    public static void main(String[] args)
    {
        Map<String, String> mapFromFile
                = HashMapFromTextFile();
>>>>>>> master

        for (Map.Entry<String, String> entry :
                mapFromFile.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
<<<<<<< HEAD
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
=======

>>>>>>> master
    }
        public static Map<String, String> HashMapFromTextFile()
        {
            Map<String, String> branchAddressMap
                    = new HashMap<String, String>();
            BufferedReader br = null;

<<<<<<< HEAD
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
=======
            try {

                // create file object
                File file = new File(filePath);

                // create BufferedReader object from the File
                br = new BufferedReader(new FileReader(file));
>>>>>>> master

                String line = null;

<<<<<<< HEAD
        // Find by postcode
        // Return clinic name by index
        if (branchPC.contains(postcodeEnter)) {
            // Create a new list to store search results
            List<Integer> searchIndex = new ArrayList<>();

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

        // TODO: Show detail: GP, time, ect.

        System.out.println("The information of this branch is as below \n");
        System.out.println("Postcode" + branchPC.get());

    }
}
ss

=======
                // read file line by line
                while ((line = br.readLine()) != null) {

                    // split the line by :
                    String[] parts = line.split(",");

                    // first part is Branch name, second is Branch Address
                    String branchName = parts[0].trim();
                    String branchAddress = parts[1].trim();

                    // put name, number in HashMap if they are
                    // not empty
                    if (!branchName.equals("") && !branchAddress.equals(""))
                        branchAddressMap.put(branchName, branchAddress);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {

                // Always close the BufferedReader
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (Exception e) {
                    };
                }
            }
            return branchAddressMap;
        }
}
>>>>>>> master
