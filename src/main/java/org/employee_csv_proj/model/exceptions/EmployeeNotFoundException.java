package org.employee_csv_proj.model.exceptions;

public class EmployeeNotFoundException extends Exception {
        public EmployeeNotFoundException(String errorMessage) {
            super(errorMessage);
        }
}
