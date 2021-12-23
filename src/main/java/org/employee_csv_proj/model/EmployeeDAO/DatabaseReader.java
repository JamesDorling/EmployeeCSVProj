package org.employee_csv_proj.model.EmployeeDAO;

import org.employee_csv_proj.controller.jdbc.DBConnectionManager;
import org.employee_csv_proj.controller.jdbc.sql_queries.SQLStatements;
import org.employee_csv_proj.logging.MyLogger;
import org.employee_csv_proj.model.EmployeeDTO;
import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public class DatabaseReader {
    public static EmployeeDTO findInDatabase(int employeeID) throws EmployeeNotFoundException {
        EmployeeDTO searchedEmployee;
        MyLogger.log(Level.FINE, "Looking for employee in database: " + employeeID);
        try {
            PreparedStatement findEmployeePreppedStatement = DBConnectionManager.dbCompanyConnection().prepareStatement(SQLStatements.FIND_EMPLOYEE_BY_ID);
            findEmployeePreppedStatement.setInt(1, employeeID);
            ResultSet resultSet = findEmployeePreppedStatement.executeQuery();


            searchedEmployee = new EmployeeDTO(resultSet);
            MyLogger.log(Level.FINE, searchedEmployee.toString());
            DBConnectionManager.closeConnection(findEmployeePreppedStatement.getConnection());

            return searchedEmployee;
        } catch (SQLException e) {
            throw new EmployeeNotFoundException("That employee does not exist or could not be found.");
        }
    }
}
