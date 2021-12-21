package org.employee_csv_proj.controller.jdbc.sql_queries;

public interface SQLEmployeeInsertion {
    String ADD_EMPLOYEE = "INSERT INTO employees" + " (`employeeID`, `title`, `firstName`, `middleInitial`, `lastName`, `gender`, `email`, `dob`, `dateJoined`, `salary`)" +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";

}
