package org.employee_csv_proj.view;

public interface PrintStrings {

    String DATABASE_ALREADY_EXISTS = "A database with that name already exists. How would you like to proceed? \n" +
            "Please type 1 to cancel -\n" +
            "2 to merge the two databases (adding any non-duplicate entries) - \n" +
            "3 to delete and overwrite the old database with the new one";

    String INVALID_INT_CHOICE = "Sorry, I didn't get that, please try again. Type 1, 2 or 3 ";

//    String RETURN_SEARCH = """
//            Employee number: %d
//            Name: %s %s %s %s
//            Gender: %c
//            Email: %s
//            Date of birth: %tD
//            Date joined: %tD
//            Salary: %d""";
//
//    String INVITE_ID_SEARCH = "You are now accessing the employee database. Please enter an ID number:";
//
//    String INVALID_ID_CHOICE = "Sorry, I didn't get that, please try again. Type a single non-negative number";
//
//    String EMPLOYEE_NOT_FOUND = "Sorry, no employees fitting those specifications could be found.";
//
//    String INVITE_TRY_AGAIN =  "Would you like to try again? (Yes or No)";
//
//    String INVALID_YES_NO = "Sorry, I didn't get that, please try again. Type Y (yes) or N (no) ";

}
