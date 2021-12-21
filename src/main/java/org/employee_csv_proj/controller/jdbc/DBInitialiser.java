package org.employee_csv_proj.controller.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class DBInitialiser {
    private static void initialiseCompanyDatabase() {
        //try {
        //    Connection connection = DBConnectionManager.dbInitialiseConnection();
        //    connection.createStatement().executeUpdate(DbInitialiseStatements.DB_INITIALISE);
        //    DBConnectionManager.closeConnection(connection);
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
    }

    private static void initialiseEmployeesTable() {
        //try {
        //    Connection connection = ConnectionManager.dbCompanyXConnection();
        //    connection.createStatement().executeUpdate(DbInitialiseStatements.DB_INITIALISE_EMPLOYEES_TABLE);
        //    ConnectionManager.closeConnection(connection);
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
    }

    public static void initialiseDB() {
        //DbInitialiser.initialiseCompanyDatabase();
        //DbInitialiser.initialiseEmployeesTable();
    }
}
