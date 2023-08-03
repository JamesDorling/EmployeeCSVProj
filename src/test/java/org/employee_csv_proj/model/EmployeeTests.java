package org.employee_csv_proj.model;

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
        singleEmployee = new EmployeeDTO(new String[]{"1331", "Mrs.", "Sin", "G", "Le", "F", "place@spartaglobal.com", "10/05/1998", "12/12/2014", "13000"});
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

    @Test
    @DisplayName("Single Employee creation test")
    void singleEmployeeCreationTest() {
        //"1331", "Mrs.", "Sin", "G", "Le", "F", "place@spartaglobal.com", "10/05/1998", "12/12/2014", "13000"
        Assertions.assertEquals("empID=1331, title='Mrs.', firstName='Sin', middleInitial=G, lastName='Le', gender=F, email='place@spartaglobal.com'"+
                ", dob=1998-10-05, dateJoined=2014-12-12, salary=13000", singleEmployee.toString()) ;
    }

    //After each - when to use?
}
