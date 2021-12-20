package org.employee_csv_proj;

import org.employee_csv_proj.model.EmployeeDTO;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Unit test for Employee DTO.
 */
public class EmployeeTests {

    private EmployeeDTO singleEmployee;


    //initialise a temp employee array to test against
    @BeforeEach
    void setup() {
        String[] employeeDetails = new String[10];
        int empID = 1331;
        employeeDetails[0] = String.valueOf(empID);
        String title = "Mrs.";
        employeeDetails[1] = title;
        String firstName = "Sin";
        employeeDetails[2] = firstName;
        char middleInitial = 'G';
        employeeDetails[3] = String.valueOf(middleInitial);
        String lastName = "Le";
        employeeDetails[4] = lastName;
        char gender = 'F';
        employeeDetails[5] = String.valueOf(gender);
        String email = "place@spartaglobal.com";
        employeeDetails[6] = email;
        LocalDate dob = LocalDate.parse("10/05/1998", DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
        employeeDetails[7] = dob.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate dateJoined = LocalDate.parse("12/12/2014", DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
        employeeDetails[8] = dateJoined.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        int salary = 13000;
        employeeDetails[9] = String.valueOf(salary);

        singleEmployee = new EmployeeDTO(employeeDetails);

    }

    //test all different attributes return what is expected
    @Test
    @DisplayName("Employee id confirm test")
    void employeeIdConfirmTest() {
        singleEmployee.setEmpID(1001);
        Assertions.assertEquals(1001, singleEmployee.getEmpID());
    }

    @Test
    @DisplayName("Employee title confirm test")
    void employeeTitleConfirmTest() {
        singleEmployee.setTitle("Mr.");
        Assertions.assertEquals("Mr.", singleEmployee.getTitle());
    }

    @Test
    @DisplayName("Employee first name confirm test ")
    void employeeFirstNameConfirmTest() {
        singleEmployee.setFirstName("Emp");
        Assertions.assertEquals("Emp", singleEmployee.getFirstName());
    }

    @Test
    @DisplayName("Employee middle initial confirm test")
    void employeeMiddleInitialConfirmTest() {
        singleEmployee.setMiddleInitial('M');
        Assertions.assertEquals('M', singleEmployee.getMiddleInitial());
    }

    @Test
    @DisplayName("Employee last name confirm test")
    void employeeLastNameConfirmTest() {
        singleEmployee.setLastName("Loy");
        Assertions.assertEquals("Loy", singleEmployee.getLastName());
    }

    @Test
    @DisplayName("Employee gender confirm test")
    void employeeGenderConfirmTest() {
        singleEmployee.setGender('M');
        Assertions.assertEquals('M', singleEmployee.getGender());
    }

    @Test
    @DisplayName("Employee email confirm test ")
    void employeeEmailConfirmTest() {
        singleEmployee.setEmail("work@spartaglobal.com");
        Assertions.assertEquals("work@spartaglobal.com", singleEmployee.getEmail());
    }

    @Test
    @DisplayName("Employee date of birth test")
    void employeeDateOfBirthTest() {
        singleEmployee.setDob("01/01/2002");
        Assertions.assertEquals(LocalDate.parse("01/01/2002", DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy")), singleEmployee.getDob());
    }

    @Test
    @DisplayName("Employee date joined confirm test")
    void employeeDateJoinedConfirmTest() {
        singleEmployee.setDateJoined("1/2/2017");
        Assertions.assertEquals(LocalDate.parse("1/2/2017", DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy")), singleEmployee.getDateJoined());
    }

    @Test
    @DisplayName("Employee salary confirm test")
    void employeeSalaryConfirmTest() {
        singleEmployee.setSalary(25000);
        Assertions.assertEquals(25000, singleEmployee.getSalary());
    }

    //After each - when to use?
}
