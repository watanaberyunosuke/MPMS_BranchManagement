package com.monash.MPMS;
import java.io.*;
import java.util.Arrays;

public class report {
    String[] index= null;
    boolean flag = true;


    public int[][] getReasonTime() {
        try{
            String indexString = "";
            fr= new FileReader("trees.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);
            indexString = bufferedReader.readLine();
            index = indexString.split(",");
        }
        catch (IOException e){
            System.out.println("Input Error!");
        }
    }

}