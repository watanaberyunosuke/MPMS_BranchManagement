FIT5136 Readme for jfal0001

report class:

getReasonTime function:
In the getReasonTime function, we firstly import the appointment data from appointment.txt file.
Then we read the first line of the file which should be the index for the database.
After that, we filter the columns which would be used in this function : time and reason.
Finally, we made these two attributes together in a list and save each of the list in the arraylist: reasonTime and return.


generateReport function:
Firstly, we need to input the arraylist return from the getReasonTime function.
Secondly, we generate the hashmap based on the input time and arraylist. The constructor of the hashmap is to take the reason as key and times for the reason is selected as value.
Finally, we can easily calculate the percentage of the reasons and print them out.