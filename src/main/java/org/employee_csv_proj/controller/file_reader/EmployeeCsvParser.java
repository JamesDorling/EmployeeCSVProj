package org.employee_csv_proj.controller.file_reader;

import org.employee_csv_proj.config.Config;
import org.employee_csv_proj.controller.jdbc.DBConnectionManager;
import org.employee_csv_proj.logging.MyLogger;
import org.employee_csv_proj.model.EmployeeDAO.DatabaseOperations;
import org.employee_csv_proj.model.EmployeeDTO;

import java.io.*;
import java.io.FileReader;
import java.sql.Connection;
import java.util.logging.Level;

public class EmployeeCsvParser {
    //No filepath needed as is provided in the config
    public static void createEmployeeData() {
        try {
            MyLogger.log(Level.INFO, "Checking for employee data.");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCSVFileLocation()));
            bufferedReader.readLine();
            Connection connection = DBConnectionManager.dbCompanyConnection();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine())
            {
                //EmployeeDAO.addEmployee(new EmployeeDTO(employeeRecord.split(",")));
                DatabaseOperations.addToDatabase(connection, new EmployeeDTO(employeeRecord.split(",")));
                //MyLogger.log(Level.FINEST, "Employee Added!");
            }
            DBConnectionManager.closeConnection(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
