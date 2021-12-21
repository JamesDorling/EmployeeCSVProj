package org.employee_csv_proj.view;

import java.util.logging.Level;

public class PrintCentre {
    public void pushToConsole(String toPrint){
//        MyLogger.log(Level.FINEST,"Printing message to console window: " + toPrint);
        System.out.println(toPrint);
    }

    public String inviteIDSearch(){
        return "You are now accessing the employee database. Please enter an ID number:";
    }
//
//    public String inviteGeneralSearch(){
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

    public String returnSearch(org.employee_csv_proj.model.EmployeeDTO employee){
        return "Employee number: " + employee.getID() + ": \n Name:" + employee.getTitle() + employee.getFirstName() +
                employee.getMiddleInitial() + employee.getLastName() + " \n Gender:" + employee.getGender() + " \n Email:" +
                employee.getEmail() + " \n DOB: " + employee.getDob() + "\n Date Joined: " + employee.getDateJoined() +
                "\n Salary: " + employee.getSalary();
    }

    public String invalidArrayLengthChoice() {
        return "Sorry, I didn't get that, please try again. Type a single non-negative number";
    }
}
