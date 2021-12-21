package org.employee_csv_proj.controller;

import org.employee_csv_proj.controller.file_reader.EmployeeCsvParser;
import org.employee_csv_proj.logging.MyLogger;
import org.employee_csv_proj.model.EmployeeDAO;
import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;
import org.employee_csv_proj.view.PrintCentre;
import org.employee_csv_proj.view.ReadCentre;

import java.util.logging.Level;

public class OrderOfOperationsCentre {

    public static void setup(){
        MyLogger.setup(); // Do not call any logs before this point!
        MyLogger.log(Level.INFO,"Program launched, logger setup complete");
        runtimeOrder();
    }

    public static void runtimeOrder() {

        EmployeeCsvParser.createEmployeeData();
        MyLogger.log(Level.INFO,"Employee CSV has been parsed, allowing user to query database.");
        searchInput();
        MyLogger.log(Level.INFO,"Program has finished.");

    }

    private static void searchInput() {
        try {
            PrintCentre.pushToConsole(PrintCentre.inviteIDSearch());
            Integer employeeID = ReadCentre.chooseID();
            MyLogger.log(Level.INFO,"Employee #" + employeeID + " found.");
            PrintCentre.pushToConsole(PrintCentre.returnSearch(EmployeeDAO.getEmployee(employeeID)));
        } catch (EmployeeNotFoundException e) {
            MyLogger.log(Level.INFO,"Employee not found.");
            PrintCentre.pushToConsole(PrintCentre.employeeNotFound());
            searchInput();
        }
    }
}
