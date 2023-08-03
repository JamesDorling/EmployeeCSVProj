package org.employee_csv_proj.controller.jdbc.sql_queries;

import org.employee_csv_proj.config.Config;

public interface DbInitialiseStatements {
    String DB_INITIALISE = "CREATE DATABASE IF NOT EXISTS " + Config.dbDatabaseName();
    String DB_CREATE_EMPLOYEES_TABLE = "CREATE TABLE employees (" +
            "employeeID INTEGER NOT NULL," +
            "title VARCHAR(10)," +
            "firstName VARCHAR(15)," +
            "middleInitial VARCHAR(1)," +
            "lastName VARCHAR(20)," +
            "gender VARCHAR(1)," +
            "email VARCHAR(40)," +
            "dob VARCHAR(10)," +
            "dateJoined VARCHAR(10)," +
            "salary VARCHAR(7), " +
            "PRIMARY KEY (employeeID)" +
            ")";
}
