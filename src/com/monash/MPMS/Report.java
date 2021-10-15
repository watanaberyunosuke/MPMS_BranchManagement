package com.monash.MPMS;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class Report {
    String[] index = null;
    String[] data;
    String line = null;
    ArrayList<String[]> reasonTime = new ArrayList<>();


    public ArrayList<String[]> getReasonTime() {
        try {
            int timeIndex = 0;
            int reasonIndex = 0;
            FileReader fr = new FileReader("Appointment.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);
            String indexString = bufferedReader.readLine();
            index = indexString.split(",");
            for (int j = 0; j < index.length; j++) {
                if (index[j].equals("time")) {
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

    public void generateReport(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the time you want to search:");
        String time = sc.nextLine();
        generateReport(getReasonTime(), time);
    }

    public Map<String,Integer> generateReport(ArrayList<String[]> reasonTime, String time){
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