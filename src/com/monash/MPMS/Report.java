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
            File fr = new File("src/com/monash/MPMS/Appointment.txt");
            if (!fr.exists()) {
                System.out.println("The file does not Exist");

            }
            String indexString;
            int timeIndex = 0;
            int reasonIndex = 1;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fr));
            indexString = bufferedReader.readLine();
            index = indexString.split(",");

            for (int j = 0; j < index.length; j++) {
                if (index[j].equals("time")) {
                    timeIndex = j;
                }
                if (index[j].equals("reason")) {
                    reasonIndex = j;
                }
            }

            for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
                data = new String[2];
                data[0] = line.split(",")[timeIndex];
                data[1] = line.split(",")[reasonIndex];
                reasonTime.add(i, data);
            }

            bufferedReader.close();

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
        Login.adminLogin();
    }

    public Map<String,Integer> generateReport(ArrayList<String[]> reasonTime, String time){
        Map<String,Integer> reportData = new HashMap<String,Integer>();
        int total = 0;

        for(int i=0; i<reasonTime.size(); i++){
            if(reasonTime.get(i)[0].equals(time)){
                total ++;
                if (!reportData.containsKey(reasonTime.get(i)[1])) {
                    reportData.put(reasonTime.get(i)[1], 1);
                } else {
                    reportData.put(reasonTime.get(i)[1], reportData.get(reasonTime.get(i)[1]) + 1);
                }
            }
        }

        for(Map.Entry<String,Integer> entry : reportData.entrySet()){
            System.out.println("During this period," + entry.getValue() * 100 / total + " percent people come for the reason that they " + entry.getKey());
        }

        return reportData;
    }


}