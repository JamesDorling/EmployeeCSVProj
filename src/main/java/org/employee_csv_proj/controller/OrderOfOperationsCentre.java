package org.employee_csv_proj.controller;

import org.employee_csv_proj.controller.file_reader.EmployeeCsvParser;
import org.employee_csv_proj.model.EmployeeDAO;
import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;
import org.employee_csv_proj.view.PrintCentre;
import org.employee_csv_proj.view.ReadCentre;

public class OrderOfOperationsCentre {
    public static void runtimeOrder() {
        EmployeeCsvParser.createEmployeeData();
        searchInput();

    }

    private static void searchInput() {
        try {
            PrintCentre.pushToConsole(PrintCentre.inviteIDSearch());
            PrintCentre.pushToConsole(PrintCentre.returnSearch(EmployeeDAO.getEmployee(ReadCentre.chooseID())));
        } catch (EmployeeNotFoundException e) {
            //e.printStackTrace();
            //LOG
            System.out.println("No employee found.");
            searchInput();
        }
    }
}
