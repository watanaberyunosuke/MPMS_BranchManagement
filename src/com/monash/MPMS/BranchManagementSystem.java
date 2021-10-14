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

public class BranchManagement {
    final static String filePath = "src/com/monash/MPMS/BranchAddress";

    public static void main(String[] args)
    {
        Map<String, String> mapFromFile
                = HashMapFromTextFile();

        for (Map.Entry<String, String> entry :
                mapFromFile.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
        public static Map<String, String> HashMapFromTextFile()
        {
            Map<String, String> branchAddressMap
                    = new HashMap<String, String>();
            BufferedReader br = null;

            try {

                // create file object
                File file = new File(filePath);

                // create BufferedReader object from the File
                br = new BufferedReader(new FileReader(file));

                String line = null;

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
