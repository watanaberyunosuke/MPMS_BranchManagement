# MPMS_BranchManagement

## Introduction

This software is designed to facilitate the Monash Patient Management System for patient to make appointment, see branch
details and GPs.

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

Get Reason Time feature:
In the getReasonTime function, the system firstly import the appointment data from database, then the system read the
index of the database. After that, the system filter the time and reason. Finally, the system return these two
attributes together in a list and save each of the list in the arraylist: reasonTime and return.

Generate Report Feature Firstly, the system read the data processed by the above feature. After that, the system
calculate based on the input time and arraylist. The system take the reason as key and times for the reason is selected
as value. Finally, the system can easily calculate the percentage of the reasons and print them out.