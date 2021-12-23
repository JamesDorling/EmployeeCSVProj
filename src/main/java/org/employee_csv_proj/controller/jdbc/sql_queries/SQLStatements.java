package org.employee_csv_proj.controller.jdbc.sql_queries;

public interface SQLStatements {
    String ADD_EMPLOYEE = "INSERT INTO employees" + " (`employeeID`, `title`, `firstName`, `middleInitial`, `lastName`, `gender`, `email`, `dob`, `dateJoined`, `salary`)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";

    String DELETE_EMPLOYEE = "DELETE FROM employees WHERE employeeID = ?";

    String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE `employeeID` = ?";
    //String FIND_EMPLOYEE_BY = "SELECT * FROM employees WHERE ? = ?";
}
