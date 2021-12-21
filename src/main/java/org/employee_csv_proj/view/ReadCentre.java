package org.employee_csv_proj.view;

import java.util.Scanner;

public class ReadCentre {

    static Scanner scan = new Scanner(System.in);

    public static Integer chooseID(){
        Integer chosenID;
        Integer inputID;
        String userInput = scan.nextLine();
//        MyLogger.log(Level.CONFIG,"The user has chosen this ID: " + userInput);

        try {
            inputID = Integer.parseInt(userInput);
        } catch (Exception e) {
//            MyLogger.log(Level.WARNING,"The user input: " + userInput + " was unable to be parsed. Asking them again");
            PrintCentre.pushToConsole(PrintCentre.invalidArrayLengthChoice());
            inputID = chooseID();
        }

        chosenID = checkID(inputID);

        return chosenID;
    }

    private static Integer checkID(Integer inputID) {
        if (0 <= inputID){
            return inputID;
        } else {
            PrintCentre.pushToConsole(PrintCentre.invalidArrayLengthChoice());
            return chooseID();
        }
    }
}
