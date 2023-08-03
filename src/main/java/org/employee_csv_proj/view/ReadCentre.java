package org.employee_csv_proj.view;

import org.employee_csv_proj.logging.MyLogger;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;

public class ReadCentre {

    static Scanner scan = new Scanner(System.in);

        public static Integer chooseDatabaseResponse(){
        Integer inputInt;
        String userInput = scan.nextLine();
        MyLogger.log(Level.CONFIG,"The user has entered this response: " + userInput);

        try {
            inputInt = Integer.parseInt(userInput);
        } catch (Exception e) {
            MyLogger.log(Level.WARNING,"The user input: " + userInput + " was unable to be parsed. Asking them again");
            PrintCentre.pushToConsole(PrintCentre.invalidIntChoice());
            inputInt = chooseDatabaseResponse();
        }

        inputInt = checkInt(inputInt);

        return inputInt;
    }

        private static Integer checkInt(Integer inputInt) {
        if (inputInt == 1 || inputInt == 2 || inputInt == 3){
            MyLogger.log(Level.FINE,"The user input: " + inputInt + " was accepted as a valid response.");
            return inputInt;
        } else {
            PrintCentre.pushToConsole(PrintCentre.invalidIntChoice());
            MyLogger.log(Level.WARNING,"The user input: " + inputInt + " was not accepted as a valid response.");
            return chooseDatabaseResponse();
        }
    }

//    public static Integer chooseID(){
//        Integer chosenID;
//        Integer inputID;
//        String userInput = scan.nextLine();
//        MyLogger.log(Level.CONFIG,"The user has chosen this ID: " + userInput);
//
//        try {
//            inputID = Integer.parseInt(userInput);
//        } catch (Exception e) {
//            MyLogger.log(Level.WARNING,"The user input: " + userInput + " was unable to be parsed. Asking them again");
//            PrintCentre.pushToConsole(PrintCentre.invalidIDChoice());
//            inputID = chooseID();
//        }
//
//        chosenID = checkID(inputID);
//
//        return chosenID;
//    }
//
//    private static Integer checkID(Integer inputID) {
//        if (0 <= inputID){
//            MyLogger.log(Level.FINE,"The user input: " + inputID + " was accepted as a potentially valid ID.");
//            return inputID;
//        } else {
//            PrintCentre.pushToConsole(PrintCentre.invalidIDChoice());
//            MyLogger.log(Level.WARNING,"The user input: " + inputID + " was not accepted as a valid ID.");
//            return chooseID();
//        }
//    }
//
//    public static boolean chooseBool(){
//        // Ask a yes-no question, then interpret the result to a boolean
//        String yesNo = chooseYesNo();
//        boolean outputBool ;
//
//        if (yesNo.equals("y") || yesNo.equals("yes")){
//            outputBool = true;
//        } else if (yesNo.equals("n") || yesNo.equals("no")){
//            outputBool = false;
//        } else {
//            MyLogger.log(Level.WARNING,"The user input: " + yesNo + " could not be resolved into a boolean. Asking them again");
//            PrintCentre.pushToConsole(PrintCentre.invalidYesNo());
//            outputBool = chooseBool();
//        }
//
//        MyLogger.log(Level.FINE,"Response interpreted as : " + outputBool);
//
//        return outputBool;
//    }
//
//    private static String chooseYesNo(){
//        String inputYN;
//        String userInput = scan.nextLine();
//        MyLogger.log(Level.CONFIG,"The user has chosen this response: " + userInput);
//
//        try {
//            inputYN = userInput;
//        } catch (Exception e) {
//            MyLogger.log(Level.WARNING,"The user input: " + userInput + " was unable to be parsed. Asking them again");
//            PrintCentre.pushToConsole(PrintCentre.invalidIDChoice());
//            inputYN = chooseYesNo();
//        }
//
//        return inputYN.toLowerCase();
//    }
}
