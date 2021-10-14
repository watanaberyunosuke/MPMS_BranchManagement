package com.monash.MPMS;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Appointment
{
    private static List<String> branchID = new ArrayList<>();
    private static List<String> branchName = new ArrayList<>();
    private static List<String> branchPC = new ArrayList<>();
    private static List<String> branchAddress = new ArrayList<>();
    private static List<String> branchOpeningHours = new ArrayList<>();
    private static List<String> branchPhone = new ArrayList<>();
    private static List<String> GPID = new ArrayList<>();
    private static List<String> GPName = new ArrayList<>();
    private static List<String> GPBranch = new ArrayList<>();
    private static List<String> reasonsToSeeGP = new ArrayList<>();
    private static String selectedBranch;
    private static String selectedGP;
    private static String selectedDay;
    private static String selectedTime;
    private static String patientStatus;
    private static String selectedReason;
    private final List<String> searchResults = new ArrayList<>();


    public Appointment()
    {
        selectedBranch = "";
        selectedGP = "";
        selectedDay = "";
        selectedTime = "";
        patientStatus = "";
        selectedReason = "";
    }

    static void loadGP()
    {
        // load file with error handling
        try
        {
            File GPFileObj = new File("src/com/monash/MPMS/GP.txt");
            Scanner fileReader = new Scanner(GPFileObj);
            while (fileReader.hasNextLine())
            {
                String GPInformation = fileReader.nextLine();
                String[] GPInfoArray = GPInformation.split(",", 4);
                if (GPInfoArray.length >= 3)
                {
                    GPID.add(GPInfoArray[0].trim());
                    GPName.add(GPInfoArray[1].trim() + " " + GPInfoArray[2].trim());
                    GPBranch.add(GPInfoArray[3].trim());
                }
            }
            fileReader.close();
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    static void loadBranch()
    {
        // load file with error handling
        try
        {
            File branchFileObj = new File("src/com/monash/MPMS/Branch.txt");
            Scanner fileReader = new Scanner(branchFileObj);
            while (fileReader.hasNextLine())
            {
                String branchInformation = fileReader.nextLine();
                String[] branchInfoArray = branchInformation.split(",", 6);
                if (branchInfoArray.length >= 5)
                {
                    branchID.add(branchInfoArray[0].trim());
                    branchName.add(branchInfoArray[1].trim());
                    branchPC.add(branchInfoArray[2].trim());
                    branchAddress.add(branchInfoArray[3].trim());
                    branchOpeningHours.add(branchInfoArray[4].trim());
                    branchPhone.add(branchInfoArray[5].trim());
                }
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    static void loadReasons()
    {
        try
        {
            File reasonsFileObj = new File("src/com/monash/MPMS/Reason to see GP.txt");
            Scanner fileReader = new Scanner(reasonsFileObj);
            while (fileReader.hasNextLine()) {
                String reasonsInformation = fileReader.nextLine();
                reasonsToSeeGP.add(reasonsInformation);
            }
            fileReader.close();
        }
        catch (IOException e)
        {
            System.out.println("An error has occurred...");
            e.printStackTrace();
        }
    }

    static void clinicSelection()
    {
        loadBranch();
        loadGP();
        loadReasons();
        System.out.println("****************************");
        System.out.println("     Book an Appointment    ");
        System.out.println("****************************");
        System.out.println("Please select a Clinic:");
        int x;
        x = 1;
        for (String element : branchName)
        {
            System.out.println(x + ". " + element);
            x = x+1;
        }
        System.out.println(x + ". To return to Patient Home Page.");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option > x)
        {
            System.out.println("Please select a number that's listed.");
            clinicSelection();
        }
        else if (option == x)
        {
            System.out.println("Returning to patient home page.");
        }
        else
        {
            option = option-1;
            selectedBranch = branchName.get(option);
            System.out.println(selectedBranch);
            GPSelection();
        }
    }
    static void GPSelection()
    {
        System.out.println("****************************");
        System.out.println("     Book an Appointment    ");
        System.out.println("****************************");
        System.out.println("Please select which GP.txt you would like to see:");
        int y;
        y = 1;
        for (String element : GPName)
        {
            System.out.println(y + ". " + element);
            y = y + 1;
        }
        System.out.println(y + ". To continue without selecting a GP.");
        y = y + 1;
        System.out.println(y + ". To return to Clinic Selection.");
        int option;
        option = 0;
        Scanner newSc = new Scanner(System.in);
        option = newSc.nextInt();
        if (option > y)
        {
            System.out.println("Please select from the options listed.");
            GPSelection();
        }
        else if (option == y)
        {
            System.out.println("Returning to Clinic Selection");
            clinicSelection();
        }
        else if (option == y - 1) {
            System.out.println("No GP Selected");
            selectedGP = "No GP selected.";
            daySelection();
        }
        else
        {
            option = option - 1;
            selectedGP = GPName.get(option);
            System.out.println(selectedGP);
            daySelection();
        }
    }

        static void daySelection()
        {
            System.out.println("****************************");
            System.out.println("     Book an Appointment    ");
            System.out.println("****************************");
            System.out.println("Please select a day for your appointment.");
            System.out.println("1. Monday 09/05");
            System.out.println("2. Tuesday 10/05");
            System.out.println("3. Wednesday 11/05");
            System.out.println("4. Thursday 12/05");
            System.out.println("5. Friday 13/05");
            System.out.println("6. Monday 16/05");
            System.out.println("7. Return to GP selection.");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                selectedDay = "Monday 09/05";
                timeSelection();
            }
            else if (option == 2)
            {
                selectedDay = "Tuesday 10/05";
                timeSelection();
            }
            else if (option == 3)
            {
                selectedDay = "Wednesday 11/05";
                timeSelection();
            }
            else if (option == 4)
            {
                selectedDay = "Thursday 12/05";
                timeSelection();
            }
            else if (option == 5)
            {
                selectedDay = "Friday 13/05";
                timeSelection();
            }
            else if (option == 6)
            {
                selectedDay = "Monday 16/05";
                timeSelection();
            }
            else if (option == 7)
            {
                GPSelection();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                daySelection();
            }
        }

        static void timeSelection()
        {
            System.out.println("****************************");
            System.out.println("     Book an Appointment    ");
            System.out.println("****************************");
            System.out.println("Please select a time for that day.");
            System.out.println("1. 9.00am");
            System.out.println("2. 9.15am");
            System.out.println("3. 9.30am");
            System.out.println("4. 9.45am");
            System.out.println("5. 10.00am");
            System.out.println("6. 10.15am");
            System.out.println("7. Return to Day Selection");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                selectedTime = "9.00am";
                patientStatus();
            }
            else if (option == 2)
            {
                selectedTime = "9.15am";
                patientStatus();
            }
            else if (option == 3)
            {
                selectedTime = "9.30am";
                patientStatus();
            }
            else if (option == 4)
            {
                selectedTime = "9.45am";
                patientStatus();
            }
            else if (option == 5)
            {
                selectedTime = "10.00am";
                patientStatus();
            }
            else if (option == 6)
            {
                selectedTime = "10.15am";
                patientStatus();
            }
            else if (option == 7)
            {
                daySelection();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                timeSelection();
            }
        }

        static void patientStatus()
        {
            System.out.println("****************************");
            System.out.println("        Patient Status      ");
            System.out.println("****************************");
            System.out.println("Please choose your patient status.");
            System.out.println("1. Existing Patient");
            System.out.println("2. New Patient");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                patientStatus = "Existing Patient";
                reasonToSeeGP();

            }
            else if (option == 2)
            {
                patientStatus = "New Patient";
                reasonToSeeGP();
            }
            else
            {
                System.out.println("Please select a listed option.");
                patientStatus();
            }
        }

        static void reasonToSeeGP()
        {
            System.out.println("****************************");
            System.out.println("      Reason to see GP.     ");
            System.out.println("****************************");
            System.out.println("Please select an option for reason to see GP.");
            int z;
            z = 0;
            for (String element : reasonsToSeeGP)
            {
                z = z+1;
                System.out.println(z + ". " + element);
            }
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            option = option - 1;
            if (option <= z-1)
            {
                selectedReason = reasonsToSeeGP.get(option);
                covidQuestionnaire();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                reasonToSeeGP();
            }
        }

        static void covidQuestionnaire()
        {
            System.out.println("****************************");
            System.out.println("    COVID-19 QUESTIONNAIRE  ");
            System.out.println("****************************");
            System.out.println("Please select which option applies to you.");
            System.out.println("1. Attended a COVID-19 hotspot or outbreak area in the past 14 days");
            System.out.println("2. Been in contact with someone infected with COVID-19 in the past 14 days");
            System.out.println("3. Currently experiencing symptoms of fever, coughing, tiredness, or sore throat in the past 14 days");
            System.out.println("4. None of the above apply");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                covidAlert();
            }
            else if (option == 2)
            {
                covidAlert();
            }
            else if (option == 3)
            {
                covidAlert();
            }
            else if (option == 4)
            {
                appointmentConfirmation();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                covidQuestionnaire();
            }
        }

        static void covidAlert()
        {
            System.out.println("****************************");
            System.out.println("       COVID-19 ALERT       ");
            System.out.println("****************************");
            System.out.println("Please search on health.gov.au and attend a free COVID-19 respiratory clinic");
            System.out.println("1. Continue with booking.");
            System.out.println("2. Return to the patient home page.");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                appointmentConfirmation();
            }
            else if (option == 2)
            {
                Login myObj = new Login();
                Login.patientLogin();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                covidAlert();
            }
        }

        static void appointmentConfirmation()
        {
            System.out.println("****************************");
            System.out.println("  Appointment Confirmation  ");
            System.out.println("****************************");
            System.out.println("Here are the details regarding your appointment.");
            System.out.println("Clinic: " + selectedBranch);
            System.out.println("Date: " + selectedDay);
            System.out.println("Time: " + selectedTime);
            System.out.println("Type of Appointment: " + selectedReason);
            System.out.println("GP: " + selectedGP);
            System.out.println("1. Details are correct, and proceed.");
            System.out.println("2. Return to appointments booking page.");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                appointmentBooked();
            }
            else if (option == 2)
            {
                clinicSelection();
            }
            else
            {
                System.out.println("Please select an option that is listed.");
                appointmentConfirmation();
            }
        }

        static void appointmentBooked()
        {
            System.out.println("****************************");
            System.out.println("     Appointment Booked     ");
            System.out.println("****************************");
            System.out.println("Here are the details regarding your appointment.");
            System.out.println("Clinic: " + selectedBranch);
            System.out.println("Date: " + selectedDay);
            System.out.println("Time: " + selectedTime);
            System.out.println("Type of Appointment: " + selectedReason);
            System.out.println("GP: " + selectedGP);
            System.out.println("1. Return to Patient Home Page");
            int option;
            option = 0;
            Scanner newSc = new Scanner(System.in);
            option = newSc.nextInt();
            if (option == 1)
            {
                Login myObj = new Login();
                Login.patientLogin();
            }
            else
            {
                System.out.println("Please select option 1.");
            }
        }

    public static void main (String[] args)
    {
        loadBranch();
        loadGP();
        loadReasons();
        clinicSelection();
    }
}
