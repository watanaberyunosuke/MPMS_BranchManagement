package com.monash.MPMS;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class report {
    String[] index= null;
    String[] data;
    String line =null;
    ArrayList<String[]> reasonTime;


    public ArrayList<String[]> getReasonTime() {
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
                if(index[j].equals("time")){
                    timeIndex = j;
                }
                if(index[j].equals("reason")){
                    reasonIndex = j;
                }
            }
            for (int i=0; (line = bufferedReader.readLine())!=null; i++){
                data[0] =  line.split(",")[timeIndex];
                data[1] =  line.split(",")[reasonIndex];

                reasonTime.add(data);

            }

        }
        catch (IOException e){
            System.out.println("Input Error!");
        }

        return reasonTime;

    }

    public Map<String,Integer> getReportData(ArrayList<String[]> reasonTime, String time){
        Map<String,Integer> reportData = new HashMap<String,Integer>();
        int total = 0;
        for(int i=0; i<reasonTime.size(); i++){
            if(reasonTime.get(i)[0].equals(time)){
                total ++;
                if(!reportData.containsKey(reasonTime.get(i)[1])){
                    reportData.put(reasonTime.get(i)[1],1);
                }
                reportData.put(reasonTime.get(i)[1],reportData.get(reasonTime.get(i)[1])+1);
            }
        }

        for(Map.Entry<String,Integer> entry : reportData.entrySet()){
            System.out.println("During this period,"+ entry.getValue()/total +" people come to"+entry.getKey());
        }

        return reportData;
    }


}