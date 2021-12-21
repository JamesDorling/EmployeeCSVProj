package org.employee_csv_proj.controller.jdbc;

import org.employee_csv_proj.controller.jdbc.sql_queries.DbInitialiseStatements;

import java.sql.Connection;
import java.sql.SQLException;

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
           Connection connection = DBConnectionManager.dbCompanyXConnection();
            connection.createStatement().executeUpdate(DbInitialiseStatements.DB_CREATE_EMPLOYEES_TABLE);
            DBConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initialiseDB() {
        DBInitialiser.initialiseCompanyDatabase();
        DBInitialiser.initialiseEmployeesTable();
    }
}
