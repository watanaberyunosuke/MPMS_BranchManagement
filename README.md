# MPMS_BranchManagement

## Introduction

## Feature 1

Feature 1 is the login feature that take input of username and password, based on the password, the system will navigate
over to patient sub system or admin sub system.

## Feature 2

Feature 2 is the appointment making feature. The system will displace all the branches in alphabetical orders, then,
patient users can select a branch to see a list of GPs' in this branch. After that, the patient can select a GP to make
appointment, if the patient didn't select a GP, the system will assign the GP with least appoints on hand. Lastly, the
patient can choose to make a new appointment by selecting the following:

* Day
* Time
* Reason to see GP

## Feature 3: Generate Status Report

getReasonTime function:
In the getReasonTime function, we firstly import the appointment data from appointment.txt file. Then we read the first
line of the file which should be the index for the database. After that, we filter the columns which would be used in
this function : time and reason. Finally, we made these two attributes together in a list and save each of the list in
the arraylist: reasonTime and return.

generateReport function:
Firstly, we need to input the arraylist return from the getReasonTime function. Secondly, we generate the hashmap based
on the input time and arraylist. The constructor of the hashmap is to take the reason as key and times for the reason is
selected as value. Finally, we can easily calculate the percentage of the reasons and print them out.