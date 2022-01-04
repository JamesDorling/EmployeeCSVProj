package org.employee_csv_proj.controller;

import org.employee_csv_proj.controller.jdbc.DBInitialiser;
import org.employee_csv_proj.logging.MyLogger;


import java.util.logging.Level;

public class OrderOfOperationsCentre {

    public static void setup(){
        MyLogger.setup(); // Do not call any logs before this point!
        MyLogger.log(Level.INFO,"Program launched, logger setup complete");

        MyLogger.log(Level.INFO, "Initialising Database");
        DBInitialiser.initialiseDB();
        MyLogger.log(Level.INFO,"Program has finished.");
    }
}
