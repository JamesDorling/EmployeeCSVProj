package org.employee_csv_proj.logging;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private static final Logger logger = Logger.getLogger("MyLogger");

    public static void setup() {
        System.out.println("setting up");
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        try {
            //One file handles the noteworthy logs
            Handler simpleHandler = new FileHandler("src/main/java/org/employee_csv_proj/logging/mainLog.log", true);
            simpleHandler.setLevel(Level.CONFIG);
            simpleHandler.setFormatter(new CustomFormatter());
            logger.addHandler(simpleHandler);
            //One file handles all logs
            Handler detailedHandler = new FileHandler("src/main/java/org/employee_csv_proj/logging/detailedLog.log", true);
            //src/main/java/org/employee_csv_proj/logging/detailedLog.log
            detailedHandler.setLevel(Level.FINEST);
            detailedHandler.setFormatter(new CustomFormatter());
            logger.addHandler(detailedHandler);

            /*fileHandler = new FileHandler("./logfile.log");//file
            SimpleFormatter simple = new SimpleFormatter();
            fileHandler.setFormatter(simple);

            LOGGER.addHandler(fileHandler);//adding Handler for file

             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        //As this application asks the user to interact with it through the console, only SEVERE logs are passed along to it.
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        logger.addHandler(consoleHandler);
    }

    public static void log(Level logLevel, String toLog){
        //System.out.println("logging");
        logger.log(logLevel, toLog);
    }
}
