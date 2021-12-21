package org.employee_csv_proj.controller.jdbc;

import org.employee_csv_proj.config.Config;
import org.employee_csv_proj.logging.MyLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBConnectionManager {
    public static Connection dbInitialiseConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbDatabaseConnectionURL(), Config.dbUsername(), Config.dbPassword());
            MyLogger.log(Level.INFO, "Connected to Database via: " + Config.dbDatabaseConnectionURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public static Connection dbCompanyXConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbDatabaseConnectionURL() + "/" + Config.dbDatabaseName(), Config.dbUsername(), Config.dbPassword());
            MyLogger.log(Level.INFO, "Connected to Database: " + Config.dbDatabaseName() + " via: " + Config.dbDatabaseConnectionURL());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            MyLogger.log(Level.INFO, "Connection Closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
