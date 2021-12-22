package org.employee_csv_proj.view;


import org.employee_csv_proj.logging.MyLogger;

import java.util.logging.Level;

public class PrintCentre {
    public static void pushToConsole(String toPrint){
        MyLogger.log(Level.INFO,"Printing message to console window: " + toPrint);
        System.out.println(toPrint);
    }

    public static String returnSearch(org.employee_csv_proj.model.EmployeeDTO employee){
        return String.format(PrintStrings.RETURN_SEARCH, employee.getEmpID(), employee.getTitle(), employee.getFirstName(), employee.getMiddleInitial(), employee.getLastName(), employee.getGender(), employee.getEmail(), employee.getDob(), employee.getDateJoined(), employee.getSalary());
    }

    //    public static String inviteGeneralSearch(){
//        return "You are now accessing the employee database. Which field(s) would you like to search? \n" +
//                "1. ID\n" +
//                "2. Title\n" +
//                "3. First name\n" +
//                "4. Middle name initial \n" +
//                "5. Last name\n" +
//                "6. Gender\n" +
//                "7. Email\n" +
//                "8. Date of Birth\n" +
//                "9. Date Joined\n" +
//                "10. Salary";
//    }

    public static String inviteIDSearch(){
        return PrintStrings.INVITE_ID_SEARCH;
    }

    public static String invalidIDChoice() {
        return PrintStrings.INVALID_ID_CHOICE;
    }

    public static String employeeNotFound() {
        return PrintStrings.EMPLOYEE_NOT_FOUND;
    }

    public static String invalidYesNo() {
        return PrintStrings.INVALID_YES_NO;
    }
}
