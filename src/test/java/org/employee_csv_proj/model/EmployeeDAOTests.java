package org.employee_csv_proj.model;

import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.time.LocalDate;

public class EmployeeDAOTests {
    private EmployeeDTO mockEmployee1;
    private EmployeeDTO mockEmployee2;
    private EmployeeDTO mockEmployee3;

    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        System.out.println(testInfo.getTestClass() + " executing");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) { System.out.println(testInfo.getTestClass() + " has completely finished testing."); }

    @BeforeEach
    void setup() {
        mockEmployee1 = Mockito.mock(EmployeeDTO.class);
        Mockito.when(mockEmployee1.getID()).thenReturn(1);
    }

    //Check employee exists is tested via testing the others. I could create another test for it, but it's a super simple
    //method, it's basically just a getter.

    @Nested
    @DisplayName("Mocked Employee Tests")
    class MockedEmployeeTests {
        @Test
        @DisplayName("Add employees test")
        void addEmployeesTest() {
            EmployeeDAO.addEmployee(mockEmployee1);
            Assertions.assertTrue(EmployeeDAO.checkEmployeeExists(1));
        }

        @Test
        @DisplayName("Get employees test")
        void getEmployeeTest() {
            EmployeeDAO.addEmployee(mockEmployee1);
            Assumptions.assumeTrue(EmployeeDAO.checkEmployeeExists(1));
            Assertions.assertDoesNotThrow(() -> EmployeeDAO.getEmployee(1));
        }

        @Test
        @DisplayName("Get employees failure test")
        void getEmployeeFailTest() {
            EmployeeDAO.addEmployee(mockEmployee1);
            Assumptions.assumeTrue(EmployeeDAO.checkEmployeeExists(1));
            Assertions.assertThrows(EmployeeNotFoundException.class, () -> EmployeeDAO.getEmployee(5));
        }

        @Test
        @DisplayName("Delete an employee test")
        void deleteEmployeeTest() {
            EmployeeDAO.addEmployee(mockEmployee1);
            Assumptions.assumeTrue(EmployeeDAO.checkEmployeeExists(1));
            EmployeeDAO.removeEmployee(mockEmployee1.getID()); //ID should return 1 anyway
            Assertions.assertThrows(EmployeeNotFoundException.class, () -> EmployeeDAO.getEmployee(1));
        }
    }

}
