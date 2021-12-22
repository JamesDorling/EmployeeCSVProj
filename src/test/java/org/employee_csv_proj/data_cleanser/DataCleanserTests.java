package org.employee_csv_proj.data_cleanser;

import org.junit.jupiter.api.*;

public class DataCleanserTests {
    private DataCleanser cleanser;

    @BeforeAll
    static void setupAll(TestInfo testInfo) {
        System.out.println(testInfo.getTestClass() + " executing");
    }

    @AfterAll
    static void tearDownAll(TestInfo testInfo) { System.out.println(testInfo.getTestClass() + " has completely finished testing."); }

    @Nested
    @DisplayName("Data Cleanser Tests Wrong Data")
    class dataCleanserWrongTests {
        @BeforeEach
        void setup() {
            cleanser = new DataCleanser("src/test/resources/TestEmployeeRecordsWrong.csv");
        }

        @Test
        @DisplayName("Check duplicate IDs test")
        void dupeIDTest() {
            Assumptions.assumeTrue(cleanser.getProvidedList() != null);
            Assertions.assertFalse(cleanser.allFieldsFull());
        }

        @Test
        @DisplayName("All Fields Full Test")
        void allFieldsFullTest() {
            Assumptions.assumeTrue(cleanser.getProvidedList() != null);
            Assertions.assertFalse(cleanser.checkUniqueIDs());
        }

    }

    @Nested
    @DisplayName("Data Cleanser Tests Correct Data")
    class dataCleanserRightTests {
        @BeforeEach
        void setup() {
            cleanser = new DataCleanser("src/test/resources/TestEmployeeRecordsRight.csv");
        }

        @Test
        @DisplayName("Check duplicate IDs test")
        void dupeIDTest() {
            Assumptions.assumeTrue(cleanser.getProvidedList() != null);
            Assertions.assertTrue(cleanser.allFieldsFull());
        }

        @Test
        @DisplayName("All Fields Full Test")
        void allFieldsFullTest() {
            Assumptions.assumeTrue(cleanser.getProvidedList() != null);
            Assertions.assertTrue(cleanser.checkUniqueIDs());
        }

    }

}
