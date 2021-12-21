package org.employee_csv_proj.view;

import org.employee_csv_proj.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintCentreTests {

    PrintCentre printCentre = new PrintCentre();
    EmployeeDTO testEmployeeDTO = new EmployeeDTO(new String[]{"1", "a", "a", "a", "a", "a", "a", "01/01/2001", "01/01/2001", "1"});

    @Test
    @DisplayName("Does inviteIDSearch return a String?")
    void doesInviteIdSearchReturnAString() {
        Assertions.assertInstanceOf(String.class, printCentre.inviteIDSearch());
    }

    @Test
    @DisplayName("Does inviteIDSearch return the expected String?")
    void doesInviteIdSearchReturnTheExpectedString() {
        String expectedString = "You are now accessing the employee database. Please enter an ID number:";
        Assertions.assertEquals(expectedString, printCentre.inviteIDSearch());
    }

    @Test
    @DisplayName("Does returnSearch return a String?")
    void doesReturnSearchReturnAString() {
        Assertions.assertInstanceOf(String.class, printCentre.returnSearch(testEmployeeDTO));
    }

    @Test
    @DisplayName("Does returnSearch return the expected String?")
    void doesReturnSearchReturnTheExpectedString() {
        String expectedString = "Employee number: " + "1" + ": \n Name:" + "a" + "a" +
                "a" + "a" + " \n Gender:" + "a" + " \n Email:" +
                "a" + " \n DOB: " + "2001-01-01" + "\n Date Joined: " + "2001-01-01" +
                "\n Salary: " + "1";
        Assertions.assertEquals(expectedString, printCentre.returnSearch(testEmployeeDTO));
    }

    @Test
    @DisplayName("Does invalidArrayLengthChoice return a String?")
    void doesInvalidArrayLengthChoiceReturnAString() {
        Assertions.assertInstanceOf(String.class, printCentre.invalidArrayLengthChoice());
    }

    @Test
    @DisplayName("Does invalidArrayLengthChoice return the expected String?")
    void doesInvalidArrayLengthChoiceReturnTheExpectedString() {
        String expectedString = "Sorry, I didn't get that, please try again. Type a single non-negative number";
        Assertions.assertEquals(expectedString, printCentre.invalidArrayLengthChoice());
    }
}
