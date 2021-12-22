package org.employee_csv_proj.model;

import org.employee_csv_proj.controller.jdbc.DBConnectionManager;
import org.employee_csv_proj.controller.jdbc.sql_queries.SQLStatements;
import org.employee_csv_proj.logging.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class DatabaseOperations {
    public static void addToDatabase(Connection connection, EmployeeDTO employee) {
        try {
            PreparedStatement addEmployeePreppedStatement = connection.prepareStatement(SQLStatements.ADD_EMPLOYEE);
            addEmployeePreppedStatement.setInt(1, employee.getEmpID());
            addEmployeePreppedStatement.setString(2, employee.getTitle());
            addEmployeePreppedStatement.setString(3, employee.getFirstName());
            addEmployeePreppedStatement.setString(4, String.valueOf(employee.getMiddleInitial()));
            addEmployeePreppedStatement.setString(5, employee.getLastName());
            addEmployeePreppedStatement.setString(6, String.valueOf(employee.getGender()));
            addEmployeePreppedStatement.setString(7, employee.getEmail());
            addEmployeePreppedStatement.setString(8, employee.getDob().toString());
            addEmployeePreppedStatement.setString(9, employee.getDateJoined().toString());
            addEmployeePreppedStatement.setString(10, Integer.toString(employee.getSalary()));
            addEmployeePreppedStatement.execute();
        } catch (SQLException e) {
            MyLogger.log(Level.WARNING, e.getMessage() + "\n" + e.getClass().toString());
            MyLogger.log(Level.SEVERE, "WARNING: Duplicate found. Not added to database. Duplicate ID:" + employee.getEmpID());
        }
    }

    public static void addToDatabase(EmployeeDTO employee) {
        try {
            PreparedStatement addEmployeePreppedStatement = DBConnectionManager.dbCompanyConnection().prepareStatement(SQLStatements.ADD_EMPLOYEE);
            addEmployeePreppedStatement.setInt(1, employee.getEmpID());
            addEmployeePreppedStatement.setString(2, employee.getTitle());
            addEmployeePreppedStatement.setString(3, employee.getFirstName());
            addEmployeePreppedStatement.setString(4, String.valueOf(employee.getMiddleInitial()));
            addEmployeePreppedStatement.setString(5, employee.getLastName());
            addEmployeePreppedStatement.setString(6, String.valueOf(employee.getGender()));
            addEmployeePreppedStatement.setString(7, employee.getEmail());
            addEmployeePreppedStatement.setString(8, employee.getDob().toString());
            addEmployeePreppedStatement.setString(9, employee.getDateJoined().toString());
            addEmployeePreppedStatement.setString(10, Integer.toString(employee.getSalary()));
            addEmployeePreppedStatement.execute();
            DBConnectionManager.closeConnection(addEmployeePreppedStatement.getConnection());
        } catch (SQLException e) {
            MyLogger.log(Level.WARNING, e.getMessage() + "\n" + e.getClass().toString());
            MyLogger.log(Level.SEVERE, "WARNING: Duplicate found. Not added to database. Duplicate ID:" + employee.getEmpID());
        }
    }

    public static void deleteFromDatabase(int employeeID) {
        try {
            PreparedStatement deleteEmployeePreppedStatement = DBConnectionManager.dbCompanyConnection().prepareStatement(SQLStatements.DELETE_EMPLOYEE);
            deleteEmployeePreppedStatement.setInt(1, employeeID);
            deleteEmployeePreppedStatement.execute();
            DBConnectionManager.closeConnection(deleteEmployeePreppedStatement.getConnection());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
