package org.employee_csv_proj.model.EmployeeDAO;

import org.employee_csv_proj.controller.jdbc.DBConnectionManager;
import org.employee_csv_proj.controller.jdbc.sql_queries.SQLStatements;
import org.employee_csv_proj.logging.MyLogger;
import org.employee_csv_proj.model.EmployeeDTO;
import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class DatabaseReader {
    public static EmployeeDTO findInDatabase(int employeeID, String findBy) throws EmployeeNotFoundException {
        EmployeeDTO searchedEmployee;
        MyLogger.log(Level.FINE, "Looking for employee in database: " + employeeID);
        try {
            PreparedStatement findEmployeePreppedStatement = DBConnectionManager.dbCompanyConnection().prepareStatement(findBy);
            findEmployeePreppedStatement.setInt(1, employeeID);
            ResultSet resultSet = findEmployeePreppedStatement.executeQuery();

            resultSet.next();
            searchedEmployee = new EmployeeDTO(new String[]{
                    Integer.toString(resultSet.getInt(1)),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7), "11/10/2000", "10/11/2000",
                    //resultSet.getString(8),
                    //resultSet.getString(9),
                    resultSet.getString(10)});
            MyLogger.log(Level.FINE, searchedEmployee.toString());

                    DBConnectionManager.closeConnection(findEmployeePreppedStatement.getConnection());


        } catch (SQLException e) {
            throw new EmployeeNotFoundException("That employee does not exist or could not be found.");
        }
        return searchedEmployee;
    }
}
