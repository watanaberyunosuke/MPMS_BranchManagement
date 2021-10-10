package com.monash.MPMS;

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

