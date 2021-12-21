package org.employee_csv_proj.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties config;

    static {
        config = new Properties();

        try {
            config.load(new BufferedReader(new FileReader("src/main/java/org/employee_csv_proj/config/config.properties")));
        } catch (IOException e) {
            //Log a failure
            e.printStackTrace();
        }
    }

    public static String employeeCSVFileLocation() {
        return config.getProperty("employee_csv_file_location");
    }

    public static String dbDatabaseConnectionURL() {
        return config.getProperty("db_connection_url");
    }

    public static String dbUsername() {
        return config.getProperty("username");
    }

    public static String dbPassword() {
        return config.getProperty("password");
    }

    public static String dbDatabaseName() {
        return config.getProperty("db_name");
    }
}
