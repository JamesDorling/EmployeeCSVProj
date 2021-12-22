package org.employee_csv_proj.model;


import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;

import java.util.TreeMap;

public class EmployeeDAOTemp {
    //Contain all employees (In a set? maybe a tree set?)
    //Searches, need a key. (Employee ID)
    //EMPLOYEE ID IS NOT SORTED BY DEFAULT. Must be a linear search unless we sort it.

    private static final TreeMap<Integer, EmployeeDTO> EMPLOYEE_MAP = new TreeMap<>();

    public static EmployeeDTO addEmployee(EmployeeDTO employeeData) {
        EMPLOYEE_MAP.put(employeeData.getEmpID(), employeeData);
        //System.out.println("employee added!");
        return employeeData;
    }

    public static EmployeeDTO getEmployee(int ID) throws EmployeeNotFoundException {
        if(checkEmployeeExists(ID)) {
            return EMPLOYEE_MAP.get(ID);
        }
        else {
            throw new EmployeeNotFoundException("That employee does not exist.");
        }
    }

    public static boolean checkEmployeeExists(int ID) {
        return EMPLOYEE_MAP.containsKey(ID);
    }

    public static EmployeeDTO removeEmployee(int ID) {
        return EMPLOYEE_MAP.remove(ID);
    }
}
