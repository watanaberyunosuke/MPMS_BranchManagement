package com.monash.MPMS;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class report {
    String[] index= null;
    String[] data;
    String line =null;
    Map<String,String> reasonTime= new HashMap<String,String>();


    public int[][] getReasonTime() {
        try{
            FileReader fr = null;
            String indexString = "";
            int timeIndex = 0;
            int reasonIndex = 0;
            fr= new FileReader("trees.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);
            indexString = bufferedReader.readLine();
            index = indexString.split(",");
            for (int j=0; j<index.length; j++){
                if(index[j] == "time"){
                    timeIndex = j;
                }
                if(index[j] == "reason"){
                    reasonIndex = j;
                }
            }
            for (int i=0; (line = bufferedReader.readLine())!=null; i++){
                data[0] =  line.split(",")[timeIndex];
                data[1] =  line.split(",")[reasonIndex];

                reasonTime.put(data[0],data[1]);

            }

        }
        catch (IOException e){
            System.out.println("Input Error!");
        }


    }

}