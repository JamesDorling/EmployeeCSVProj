package org.employee_csv_proj.controller;

import org.employee_csv_proj.controller.jdbc.DBInitialiser;
import org.employee_csv_proj.logging.MyLogger;

import java.util.logging.Level;

public class OrderOfOperationsCentre {

    public static void setup(){
        MyLogger.setup(); // Do not call any logs before this point!
        MyLogger.log(Level.INFO,"Program launched, logger setup complete");
//        String databaseBehaviour = "merge";
//        if ("test whether database already exists"){
//            if (!useDefaults){
//                databaseBehaviour = setDatabaseBehaviour();
//            }
//        }
        runtimeOrder();
    }

//    private static String setDatabaseBehaviour() {
//        PrintCentre.pushToConsole(PrintCentre.databaseAlreadyExists());
//        Integer behaviourInt = ReadCentre.chooseDatabaseResponse();
//
//        if (behaviourInt == 2){
//            return "merge";
//        } else if (behaviourInt == 3){
//            return "overwrite";
//        } else {
//            return "cancel";
//        }
//    }

    public static void runtimeOrder() {
        MyLogger.log(Level.INFO, "Initialising Database");
        DBInitialiser.initialiseDB();
//        MyLogger.log(Level.INFO,"Allowing user to query database.");
//        searchInput();
        MyLogger.log(Level.INFO,"Program has finished.");

    }


//    private static void searchInput() {
//        try {
//            PrintCentre.pushToConsole(PrintCentre.inviteIDSearch());
//            Integer employeeID = ReadCentre.chooseID();
//            EmployeeDTO foundEmployee = DatabaseReader.findInDatabase(employeeID);
//            PrintCentre.pushToConsole(PrintCentre.returnSearch(foundEmployee));
//            PrintCentre.pushToConsole(PrintCentre.inviteTryAgain());
//            if (ReadCentre.chooseBool()){searchInput();}
//        } catch (EmployeeNotFoundException e) {
//            MyLogger.log(Level.INFO,"Employee not found.");
//            PrintCentre.pushToConsole(PrintCentre.employeeNotFound());
//            PrintCentre.pushToConsole(PrintCentre.inviteTryAgain());
//            if (ReadCentre.chooseBool()){searchInput();}
//        }
//    }

}
