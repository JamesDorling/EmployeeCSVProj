package org.employee_csv_proj.view;

import org.employee_csv_proj.view.PrintCentre;

import java.util.Scanner;

public class ReadCentre {

    Scanner scan = new Scanner(System.in);
    PrintCentre printCentre = new PrintCentre();

    public Integer chooseID(){
        Integer chosenID;
        Integer inputID;
        String userInput = scan.nextLine();
//        MyLogger.log(Level.CONFIG,"The user has chosen this ID: " + userInput);

        try {
            inputID = Integer.parseInt(userInput);
        } catch (Exception e) {
//            MyLogger.log(Level.WARNING,"The user input: " + userInput + " was unable to be parsed. Asking them again");
            printCentre.pushToConsole(printCentre.invalidArrayLengthChoice());
            inputID = this.chooseID();
        }

        chosenID = checkID(inputID);

        return chosenID;
    }

    private Integer checkID(Integer inputID) {
        if (0 <= inputID){
            return inputID;
        } else {
            printCentre.pushToConsole(printCentre.invalidArrayLengthChoice());
            return chooseID();
        }
    }
}
