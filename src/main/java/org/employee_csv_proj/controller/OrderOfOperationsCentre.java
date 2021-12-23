package org.employee_csv_proj.controller;

import org.employee_csv_proj.controller.jdbc.DBInitialiser;
import org.employee_csv_proj.logging.MyLogger;
import org.employee_csv_proj.model.EmployeeDAO.DatabaseReader;
import org.employee_csv_proj.model.EmployeeDTO;
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
        MyLogger.log(Level.INFO, "Initialising Database");
        DBInitialiser.initialiseDB();
        MyLogger.log(Level.INFO,"Allowing user to query database.");
        searchInput();
        MyLogger.log(Level.INFO,"Program has finished.");

    }

    private static void searchInput() {
        try {
            PrintCentre.pushToConsole(PrintCentre.inviteIDSearch());
            Integer employeeID = ReadCentre.chooseID();
            EmployeeDTO foundEmployee = DatabaseReader.findInDatabase(employeeID);
            PrintCentre.pushToConsole(PrintCentre.returnSearch(foundEmployee));
            PrintCentre.pushToConsole(PrintCentre.inviteTryAgain());
            if (ReadCentre.chooseBool()){searchInput();}
        } catch (EmployeeNotFoundException e) {
            MyLogger.log(Level.INFO,"Employee not found.");
            PrintCentre.pushToConsole(PrintCentre.employeeNotFound());
            PrintCentre.pushToConsole(PrintCentre.inviteTryAgain());
            if (ReadCentre.chooseBool()){searchInput();}
        }
    }
}
