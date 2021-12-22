package org.employee_csv_proj.controller.jdbc;

import org.employee_csv_proj.controller.file_reader.EmployeeCsvParser;
import org.employee_csv_proj.controller.jdbc.sql_queries.DbInitialiseStatements;
import org.employee_csv_proj.logging.MyLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBInitialiser {
    private static void initialiseCompanyDatabase() {
        try {
            Connection connection = DBConnectionManager.dbInitialiseConnection();
            connection.createStatement().executeUpdate(DbInitialiseStatements.DB_INITIALISE);
            DBConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initialiseEmployeesTable() {
        try {
           Connection connection = DBConnectionManager.dbCompanyConnection();
            connection.createStatement().executeUpdate(DbInitialiseStatements.DB_CREATE_EMPLOYEES_TABLE);
            MyLogger.log(Level.INFO, "Database does not exist. Making and filling new one.");
            EmployeeCsvParser.createEmployeeData();
            DBConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            //e.printStackTrace();
            MyLogger.log(Level.INFO, "Database Already Exists.");
        }
    }

    public static void initialiseDB() {
        DBInitialiser.initialiseCompanyDatabase();
        DBInitialiser.initialiseEmployeesTable();
    }
}
