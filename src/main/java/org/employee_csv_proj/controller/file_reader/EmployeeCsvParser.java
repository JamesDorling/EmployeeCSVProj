package org.employee_csv_proj.controller.file_reader;

import org.employee_csv_proj.config.Config;

import java.io.*;
import java.io.FileReader;

public class EmployeeCsvParser {
    //No filepath needed as is provided in the config
    public static void createEmployeeData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCSVFileLocation()));
            bufferedReader.readLine();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine())
            {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createEmployeeData();
    }

}
