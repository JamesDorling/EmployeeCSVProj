package org.employee_csv_proj.model;


import org.employee_csv_proj.model.exceptions.EmployeeNotFoundException;

import java.util.TreeMap;

public class EmployeeDAO {
    //Contain all employees (In a set? maybe a tree set?)
    //Searches, need a key. (Employee ID)
    //EMPLOYEE ID IS NOT SORTED BY DEFAULT. Must be a linear search unless we sort it.

    private static final TreeMap<Integer, EmployeeDTO> EMPLOYEE_MAP = new TreeMap<>();

    public static void addEmployee(EmployeeDTO employeeData) {
        EMPLOYEE_MAP.put(employeeData.getID(), employeeData);
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

    public static void removeEmployee(int ID) {
        EMPLOYEE_MAP.remove(ID);
    }
}
