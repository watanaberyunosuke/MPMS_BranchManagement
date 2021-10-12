package com.monash.MPMS;
import java.util.Scanner;
import java.util.HashMap;
import java.util.*;

public class Branch {
    int x;
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
        x = 1;
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

    public static void main(String[] args)
    {
        /** int x = 1;
        HashMap<String, String> branchName = new HashMap<String, String>();
        branchName.put("BR001", "Clayton Station Branch");
        branchName.put("BR002", "Caulfield Branch");
        branchName.put("BR003", "Clayton Campus Branch");
        branchName.put("BR004", "Glen Iris Branch");
        HashMap<String, String> branchAddress = new HashMap<String, String>();
        branchAddress.put("BR001", "12 Clayton Road, Clayton");
        branchAddress.put("BR002", "900 Dandenong Road, Caulfield");
        branchAddress.put("BR003", "32 Wellington Road, Clayton");
        branchAddress.put("BR004", "1256 High Street, Glen Iris");
        HashMap<String, String> branchPostCode = new HashMap<String, String>();
        branchPostCode.put("BR001", "3168");
        branchPostCode.put("BR002", "3162");
        branchPostCode.put("BR003", "3168");
        branchPostCode.put("BR004", "3146");
        HashMap<String, String> branchOpeningTime = new HashMap<String, String>();
        branchOpeningTime.put("BR001", "9am - 5pm");
        branchOpeningTime.put("BR002", "8am - 5pm");
        branchOpeningTime.put("BR003", "8am - 3pm");
        branchOpeningTime.put("BR004", "9am - 6pm");
        HashMap<String, String> selectionMap = new HashMap<String, String>();
        for (String i : branchName.values())
        {
            String s = Integer.toString(x);
            selectionMap.put(s, i);
            System.out.println(x + ". " + i);
            x = x + 1;
        }
        int selection;
        Scanner newNumber = new Scanner(System.in);
        selection = Integer.parseInt(newNumber.nextLine());
        String str = Integer.toString(selection);
        System.out.println(selectionMap.get(str));
        String stu;
        stu = selectionMap.get(str);
        System.out.println(branchOpeningTime.get(stu));
         */
        int x = 1;
        HashMap<String, String> branchName = new HashMap<String, String>();
        branchName.put("BR001", "Clayton Station Branch");
        branchName.put("BR002", "Caulfield Branch");
        branchName.put("BR003", "Clayton Campus Branch");
        branchName.put("BR004", "Glen Iris Branch");
        HashMap<String, String> branchPhone = new HashMap<String, String>();
        branchPhone.put("Clayton Station Branch", "95420495");
        branchPhone.put("Caulfield Branch", "95329504");
        branchPhone.put("Clayton Campus Branch", "95930215");
        branchPhone.put("Glen Iris Branch", "95430205");
        HashMap<String, String> branchAddress = new HashMap<String, String>();
        branchAddress.put("Clayton Station Branch", "12 Clayton Road, Clayton");
        branchAddress.put("Caulfield Branch", "900 Dandenong Road, Caulfield");
        branchAddress.put("Clayton Campus Branch", "32 Wellington Road, Clayton");
        branchAddress.put("Glen Iris Branch", "1256 High Street, Glen Iris");
        HashMap<String, String> branchPostCode = new HashMap<String, String>();
        branchPostCode.put("Clayton Station Branch", "3168");
        branchPostCode.put("Caulfield Branch", "3162");
        branchPostCode.put("Clayton Campus Branch", "3168");
        branchPostCode.put("Glen Iris Branch", "3146");
        HashMap<String, String> branchOpeningTime = new HashMap<String, String>();
        branchOpeningTime.put("Clayton Station Branch", "9am - 5pm");
        branchOpeningTime.put("Caulfield Branch", "8am - 5pm");
        branchOpeningTime.put("Clayton Campus Branch", "8am - 3pm");
        branchOpeningTime.put("Glen Iris Branch", "9am - 6pm");
        HashMap<String, String> selectionMap = new HashMap<String, String>();
        for (String i : branchName.values())
        {
            String s = Integer.toString(x);
            selectionMap.put(s, i);
            System.out.println(x + ". " + i);
            x = x + 1;
        }
        int selection;
        Scanner newNumber = new Scanner(System.in);
        selection = Integer.parseInt(newNumber.nextLine());
        String str = Integer.toString(selection);
        System.out.println("You have selected option " + selection);
        System.out.println("Branch: " + selectionMap.get(str));
        String stu;
        stu = selectionMap.get(str);
        System.out.println("Address: " + branchAddress.get(stu));
        System.out.println("Post code: " + branchPostCode.get(stu));
        System.out.println("Phone Number: " + branchPhone.get(stu));
        System.out.println("Opening Hours: " + branchOpeningTime.get(stu));


        /**
         * System.out.println(branchOpeningTime);
         *         System.out.println(branchOpeningTime.get("BR001"));
         */

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

