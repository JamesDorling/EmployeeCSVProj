package org.employee_csv_proj.model.data_cleanser;

import org.employee_csv_proj.controller.file_reader.EmployeeCsvParser;
import org.employee_csv_proj.logging.MyLogger;

import java.util.*;
import java.util.logging.Level;

//ASK KIERAN WHERE THIS SHOULD GO
public class DataCleanser{
    private ArrayList<String[]> providedList;

    public DataCleanser(String filepath) {
        this.providedList = EmployeeCsvParser.checkEmployeeData(filepath);
    }

    public boolean checkDataQuality() {
        return checkUniqueIDs() && allFieldsFull() && checkNameSurnameDOB();
    }

    public ArrayList<String[]> getProvidedList() {
        return providedList;
    }

    public boolean checkUniqueIDs() {
        ArrayList<String[]> IDs = new ArrayList<>();
        ArrayList<String[]> duplicatesToRemove = new ArrayList<>();
        Iterator<String[]> iterator = providedList.iterator();
        boolean result = true;
        boolean isDupe = false;
        while(iterator.hasNext()){
            String[] currentEmployee = iterator.next();
            isDupe = removeDuplicates(IDs, currentEmployee);
            if(!isDupe) {
                IDs.add(currentEmployee);
            }
            else {
                duplicatesToRemove.add(currentEmployee);
                iterator.remove();
                result = false;
            }
        }


        iterator = providedList.iterator();
        while(iterator.hasNext()) {
            deleteOriginalDuplicates(duplicatesToRemove, iterator);
        }
        return result;
    }

    private boolean removeDuplicates(ArrayList<String[]> IDs, String[] currentEmployee) {
        boolean isDupe = false;
        for (String[] currentEmployeeComparison : IDs) {
            if (currentEmployeeComparison[0].equals(currentEmployee[0])) {
                isDupe = true;
                MyLogger.log(Level.SEVERE, "Duplicate ID found. Employee Details: \n" + Arrays.toString(currentEmployee));
                MyLogger.log(Level.SEVERE, "Duplicate with's details: \n" + Arrays.toString(currentEmployeeComparison));
            }
        }
        return isDupe;
    }

    private void deleteOriginalDuplicates(ArrayList<String[]> duplicatesToRemove, Iterator<String[]> iterator) {
        String[] currentEmployee = iterator.next();
        for (String[] dupes : duplicatesToRemove) {
            if (dupes[0].equals(currentEmployee[0])) {
                MyLogger.log(Level.SEVERE, "Duplicate ID removed. Employee Details: \n" + Arrays.toString(currentEmployee));
                iterator.remove();
            }
        }
    }

    public boolean allFieldsFull() {
        boolean result = true;
        Iterator<String[]> listIterator = providedList.iterator();
        while(listIterator.hasNext()){
            String[] currentElement = listIterator.next();
            if(currentElement.length != 10) {
                result = false;
                MyLogger.log(Level.SEVERE, "Missing or incorrect data. Data provided: " + Arrays.toString(currentElement));
                listIterator.remove();
            }
        }
        return result;
    }

    //Nested class for name and dob
    private class nameAndDob {
        private final String[] EMPLOYEE_DATA;
        private boolean duplicate;

        public nameAndDob(String[] employee, boolean dupe) {
            EMPLOYEE_DATA = employee;
            duplicate = dupe;
        }

        public boolean compare(String[] employee) {
            return (EMPLOYEE_DATA[2].equals(employee[2]) && EMPLOYEE_DATA[4].equals(employee[4]) && EMPLOYEE_DATA[7].equals(employee[7]));
        }

        public void isADupe() {
            duplicate = true;
        }

        @Override
        public String toString() {
            return EMPLOYEE_DATA[2] + EMPLOYEE_DATA[4] + EMPLOYEE_DATA[7] + duplicate;
        }

        public boolean getDupe () {
            return duplicate;
        }
    }
    //2,4,7
    public boolean checkNameSurnameDOB() {
        boolean result = true;
        ArrayList<DataCleanser.nameAndDob> dataToCheckAgainst = new ArrayList<>(0);
        MyLogger.log(Level.INFO, "Checking names, surnames and date of births for duplicates.");
        for(String[] employee : this.providedList) {
            boolean dupe = false;
            for(DataCleanser.nameAndDob previousEmployee : dataToCheckAgainst) {
                if(previousEmployee.compare(employee)) {
                    previousEmployee.isADupe();
                    dupe = true;
                }
            }
            dataToCheckAgainst.add(new DataCleanser.nameAndDob(employee, dupe));
        }

        Iterator<nameAndDob> dataLoggerAndDeleter = dataToCheckAgainst.iterator();
        while(dataLoggerAndDeleter.hasNext()) {
            if(dataLoggerAndDeleter.next().getDupe()) {
                dataLoggerAndDeleter.remove();
                result = false;
            }
        }

        return result;
    }
}
