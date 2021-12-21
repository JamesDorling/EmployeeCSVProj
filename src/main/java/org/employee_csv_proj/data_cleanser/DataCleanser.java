package org.employee_csv_proj.data_cleanser;

import org.employee_csv_proj.controller.file_reader.EmployeeCsvParser;

import java.util.ArrayList;

//ASK KIERAN WHERE THIS SHOULD GO
public class DataCleanser {
    private ArrayList<String[]> providedList;

    public DataCleanser(String filepath) {
        this.providedList = EmployeeCsvParser.checkEmployeeData(filepath);
    }

    public boolean checkDataQuality() {
        if(checkUniqueIDs() && allFieldsFull()) {
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<String[]> getProvidedList() {
        return providedList;
    }

    public boolean checkUniqueIDs() {
        boolean result = true;
        ArrayList<Integer> IDs = new ArrayList<>();
        for(String[] employee : providedList) {
            if(IDs.contains(Integer.parseInt(employee[0]))) {
                result = false;
                //System.out.println(employee[0] + employee[1] + employee[2] + employee[3] + employee[4] + employee[5] + employee[6] + employee[7] + employee[8] + employee[9]);
                break;
            }
            else {
                IDs.add(Integer.parseInt(employee[0]));
            }
        }
        return result;
    }

    public boolean allFieldsFull() {
        boolean result = true;
        for(String[] employee : providedList) {
            if(employee.length == 9) {
                result = false;
                break;
            }
        }
        return result;
    }
}
