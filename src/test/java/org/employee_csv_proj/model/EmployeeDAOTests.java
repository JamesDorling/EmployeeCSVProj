package org.employee_csv_proj.model;

import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class EmployeeDAOTests {
    private EmployeeDTO mockEmployee1;

    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        System.out.println(testInfo.getTestClass() + " executing");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) { System.out.println(testInfo.getTestClass() + " has completely finished testing."); }

    @BeforeEach
    void setup() {
        mockEmployee1 = Mockito.mock(EmployeeDTO.class);
        Mockito.when(mockEmployee1.getEmpID()).thenReturn(1);
    }

    //Check employee exists is tested via testing the others. I could create another test for it, but it's a super simple
    //method, it's basically just a getter.

    @Nested
    @DisplayName("Mocked Employee Tests")
    class MockedEmployeeTests {
        @Test
        @DisplayName("Add employees test")
        void addEmployeesTest() {
            Assertions.assertEquals(EmployeeDAOTemp.addEmployee(mockEmployee1), mockEmployee1);
        }

        @Test
        @DisplayName("Check employee exists test")
        void checkEmployeesTest() {
            EmployeeDAOTemp.addEmployee(mockEmployee1);
            Assertions.assertTrue(EmployeeDAOTemp.checkEmployeeExists(1));
        }

        @Test
        @DisplayName("Get employees test")
        void getEmployeeTest() {
            EmployeeDAOTemp.addEmployee(mockEmployee1);
            Assumptions.assumeTrue(EmployeeDAOTemp.checkEmployeeExists(1));
            Assertions.assertDoesNotThrow(() -> EmployeeDAOTemp.getEmployee(1));
        }

        @Test
        @DisplayName("Get employees failure test")
        void getEmployeeFailTest() {
            Assertions.assertThrows(EmployeeNotFoundException.class, () -> EmployeeDAOTemp.getEmployee(5));
        }

        @Test
        @DisplayName("Delete an employee test")
        void deleteEmployeeTest() {
            EmployeeDAOTemp.addEmployee(mockEmployee1);
            Assumptions.assumeTrue(EmployeeDAOTemp.checkEmployeeExists(1));
            Assumptions.assumeTrue(EmployeeDAOTemp.removeEmployee(mockEmployee1.getEmpID()).equals(mockEmployee1)); //ID should return 1 anyway
            Assertions.assertThrows(EmployeeNotFoundException.class, () -> EmployeeDAOTemp.getEmployee(1));
        }
    }

}
