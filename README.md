# Employee CSV Project
This is a group project to introduce us to working in a team and with databases.

## Table of Contents
* [How to use](#how-to-use)
* [Data Cleansing](#data-cleansing)
* [Database](#database)
* [Testing](#testing)
* [Team Management](#team-management)
* [What have we learned?](#what-have-we-learned)

### How to use
Firstly, to set up a database change the dummy config login and password details via this filepath:
src/main/java/org/employee_csv_proj/config/configDummy.properties
and copy that file to the same location with the name "config.properties". This config file should be used to link up a
CSV file containing the employee data to add to the database.

Then, once the config file is filled out, simply run the program to cleanse the data and add all employees to the
database. Please note, any duplicates will not be added, and the names and full details will be logged to a log file.

### Data Cleansing
The data is cleansed for duplicates and faulty data. Any data that does not pass the cleansing is logged to the log
files stored in "src/main/java/org/employee_csv_proj/logging".

The data is checked for duplicates in two fields. The first field is the employee ID numbers, as that is the primary
key used to sort the database. The second field is a combination of the first name, the surname and the date of birth.
This is because every other piece of data could be duplicated (for example two people having the same first name), but 
having the full name and date of birth be exact matches is too unlikely to not be a mistake.

The data is also checked to make sure that it contains the necessary amount of data. This means that any employee that
does not have the correct amount of data will be removed and logged.

### Database 


### Testing


### Team Management


### What Have We Learned?
