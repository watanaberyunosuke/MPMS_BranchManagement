package com.monash.MPMS;

public class GP {

    String GPId;
    String GPFName;
    String GPLName;
    String BranchId;

    /**
     * Parameterised Constructor
     * @param GPId
     * @param GPFName
     * @param GPLName
     * @param BranchId
     */

    public GP(String GPId, String GPFName, String GPLName, String BranchId){
        this.GPId = GPId;
        this.GPFName = GPFName;
        this.GPLName = GPLName;
        this.BranchId = BranchId;
    }

    // Accessor
    public String GPId () {
        return this.GPId = GPId;
    }

}
