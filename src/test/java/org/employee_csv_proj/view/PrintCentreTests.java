package org.employee_csv_proj.view;

import org.employee_csv_proj.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintCentreTests {

    EmployeeDTO testEmployeeDTO = new EmployeeDTO(new String[]{"1", "a", "a", "a", "a", "a", "a", "01/01/2001", "01/01/2001", "1"});

    @Test
    @DisplayName("Does inviteIDSearch return a String?")
    void doesInviteIdSearchReturnAString() {
        Assertions.assertInstanceOf(String.class, PrintCentre.inviteIDSearch());
    }

    @Test
    @DisplayName("Does inviteIDSearch return the expected String?")
    void doesInviteIdSearchReturnTheExpectedString() {
        String expectedString = "You are now accessing the employee database. Please enter an ID number:";
        Assertions.assertEquals(expectedString, PrintCentre.inviteIDSearch());
    }

    @Test
    @DisplayName("Does returnSearch return a String?")
    void doesReturnSearchReturnAString() {
        Assertions.assertInstanceOf(String.class, PrintCentre.returnSearch(testEmployeeDTO));
    }

    @Test
    @DisplayName("Does returnSearch return the expected String?")
    void doesReturnSearchReturnTheExpectedString() {
        String expectedString = "Employee number: " + "1" + ": \n Name:" + "a" + "a" +
                "a" + "a" + " \n Gender:" + "a" + " \n Email:" +
                "a" + " \n DOB: " + "2001-01-01" + "\n Date Joined: " + "2001-01-01" +
                "\n Salary: " + "1";
        Assertions.assertEquals(expectedString, PrintCentre.returnSearch(testEmployeeDTO));
    }

    @Test
    @DisplayName("Does invalidIDChoice return a String?")
    void doesInvalidIDChoiceReturnAString() {
        Assertions.assertInstanceOf(String.class, PrintCentre.invalidIDChoice());
    }

    @Test
    @DisplayName("Does invalidIDChoice return the expected String?")
    void doesInvalidIDChoiceReturnTheExpectedString() {
        String expectedString = "Sorry, I didn't get that, please try again. Type a single non-negative number";
        Assertions.assertEquals(expectedString, PrintCentre.invalidIDChoice());
    }

    @Test
    @DisplayName("Does employeeNotFound return a String?")
    void doesEmployeeNotFoundReturnAString() {
        Assertions.assertInstanceOf(String.class, PrintCentre.employeeNotFound());
    }

    @Test
    @DisplayName("Does employeeNotFound return the expected String?")
    void doesEmployeeNotFoundReturnTheExpectedString() {
        String expectedString = "Sorry, no employees fitting those specifications could be found. Would you like to try again?";
        Assertions.assertEquals(expectedString, PrintCentre.employeeNotFound());
    }

    @Test
    @DisplayName("Does invalidYesNo return a String?")
    void doesInvalidYesNoReturnAString() {
        Assertions.assertInstanceOf(String.class, PrintCentre.invalidYesNo());
    }

    @Test
    @DisplayName("Does invalidYesNo return the expected String?")
    void doesInvalidYesNoReturnTheExpectedString() {
        String expectedString = "Sorry, I didn't get that, please try again. Type Y (yes) or N (no) ";
        Assertions.assertEquals(expectedString, PrintCentre.invalidYesNo());
    }
}
